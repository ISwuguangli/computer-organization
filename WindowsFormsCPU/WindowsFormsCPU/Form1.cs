using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using System.Text.RegularExpressions;

namespace WindowsFormsCPU
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            //通用寄存器初始化
            R0.Text = "00000000";
            R1.Text = "00000000";
            R2.Text = "00000000";
            R3.Text = "00000000";
            R4.Text = "00000000";
            R5.Text = "00000000";
            R6.Text = "00000000";
            R7.Text = "00000000";
            R8.Text = "00000000";
            R9.Text = "00000000";
            R10.Text = "00000000";
            R11.Text = "00000000";
            R12.Text = "00000000";
            R13.Text = "00000000";
            R14.Text = "00000000";
            R15.Text = "00000000";
            SR.Text = "00000000";
        }
        //数值初始化
        //指令数组总数
        public int instructionSum = 0;
        //指令的字符串数组
        public string[] instruction;
        //单步执行指令的步数
        public int stepCount = 0;

        //空格指令分割函数，返回的是指令码的字符串
        static string getIrString(string str)
        {
            string[] tempStr;
            tempStr = str.Split(' ');

            //测试空格分割
            //foreach (string i in tempStr)
            //{
            //    Console.Write("经过空字符分割的指令");
            //    Console.WriteLine(i);
            //}
            //空分割测试函数
            Console.WriteLine("getIrString，返回的指令码是{0}",tempStr[0]);
            return tempStr[0];
        }

        //指令码译码函数，要求形参是完整的指令，返回对应的指令码的字符串
        static string getIrBinaryString(string str)
        {
            str = getIrString(str);
            string tempStr = getIrString(str);
            Console.WriteLine("getIrBinaryString 指令码{0}", tempStr);
            if (str == "add")
                tempStr = "00001100";
            else if (str == "sub")
                tempStr = "00001000";
            else if (str == "Mul")
                tempStr = "10011100";
            else if (str == "RJMP")
                tempStr = "1100";
            else if (str == "BRMI")
                tempStr = "11110001";
            else if (str == "Mov")
                tempStr = "00101100";
            else if (str == "Ldi")
            {
                tempStr = "1110";
                Console.WriteLine("getIrBinaryString 中，翻译了Ldi");
            }
               // tempStr = "1110";
            else if (str == "Ld")
                tempStr = "10010000";
            else if (str == "st")
                tempStr = "10010010";
            else if (str == "nop")
                tempStr = "00000000";
            tempStr = newStr(tempStr);
            return tempStr;
        }

        //指令拼接部分，返回部分一个长度为8的字符串，将一个字符串复制n次
        //补上n个0
        static string copyStr(string str)
        {
                int n = 8 - str.Length;
                char[] sub = new char[n];
                for (int i = 0; i < n; i++)
                {
                    sub[i] = '0';
                }
                string str1 = new string(sub);
                return str1;
        }

        //构造一个8位的新的字符串
        static string newStr(string str)
        {
            str = copyStr(str) + str;
            return str;
        }

        //空指令分割函数，返回的是地址码部分，包括寄存器和操作数两部分,即register+resgiter/number
        static string getAdrString(string str)
        {
            string[] tempStr;
            tempStr = str.Split(' ');
            return tempStr[1];
        }

        //“，”指令分割函数，将“，”两边分开，即将地址码两边分开
        //形参是一个完整的指令字符串，返回为地址码前半部分，返回示例：R0
        static string getFirstAdr(string str)
        {
            str = getAdrString(str);
            string[] tempStr;
            tempStr = str.Split(',');

            //测试经过逗号分割
            //foreach (string i in tempStr)
            //{
            //    Console.Write("经过逗号分割的字符串");
            //    Console.WriteLine(i);
            //}
            return tempStr[0];
        }

        //形参是一个完整的指令字符串，地址后半部分为数值，返回该数值的二进制字符串，外部调用用这个接口
        //返回示例00000000
        static string getSecondAdr(string str)
        {
            str = getAdrString(str);
            string[] tempStr;
            tempStr = str.Split(',');
            string str1 = tempStr[1];
            string str2 = getBinaryString(str1);
            str2 = newStr(str2);
            return str2;
        }

        //形参是一个完整的指令的字符串，返回的是地址码的第二个寄存器
        static string getSecondRegister(string str)
        {
            string tempStr = getAdrString(str);
            string[] tempStr1 = tempStr.Split(',');
            string tempStr2 = tempStr1[1];
            return tempStr2;
        }
        //形参是一个16进制数字符串，返回一个二进制字符串
        static string getBinaryString(string str)
        {
            string tempStr = "我出错啦";
            if (str.Length == 2)
            {
                tempStr = intToBinary(hexToInt(str[0], str[1]));
            }
            else if(str.Length == 1)
            {
                tempStr= intToBinary(charHexToInt(str[0]));
            }
            return tempStr;
        }
        //寄存器赋值函数
        public void setRegister(string registerName, string registerText)
        {
            foreach (Control c in this.Controls)
            {
                if (c is TextBox && c.Name == registerName)
                {
                    TextBox tempTxt = c as TextBox;
                    tempTxt.Text = registerText;
                }
            }
        }

        //获得指定寄存器的文本内容，返回的是一个二进制字符串
        public string getRegisterText(string registerName)
        {
            string str = "1";
            foreach(Control c in this.Controls)
            {
                if (c is TextBox && c.Name == registerName)
                {
                    TextBox tempTxt = c as TextBox;
                    str = tempTxt.Text;
                }
            }
            return str;
        }

        //加法指令运算，形参为两个二进制字符串，传出的是相加后的结果字符串
        static string add(string str1, string str2)
        {
            string result = "加法的结果";
            int a1 = Convert.ToInt32(str1, 2);
            Console.WriteLine("a1的值是{0}", a1);
            int a2 = Convert.ToInt32(str2, 2);
            Console.WriteLine("a2的值是{0}",a2);
            int a3 = a1 + a2;
            result = Convert.ToString(a3, 2);
            Console.WriteLine("result is {0}",result);
            return result;
        }

        //减法指令运算，形参为两个二进制字符串，传出的是相减后的结果字符串
        static string sub(string str1, string str2)
        {
            string result = "减法的结果";
            int a1 = Convert.ToInt32(str1, 2);
            Console.WriteLine("a1的值是{0}", a1);
            int a2 = Convert.ToInt32(str2, 2);
            Console.WriteLine("a2的值是{0}", a2);
            int a3 = a1 - a2;
            result = Convert.ToString(a3, 2);
            Console.WriteLine("result is {0}", result);
            result = newStr(result);
            return result;
        }

        //乘法指令运算，形参为两个二进制字符串，传出的是相减后的结果字符串
        static string[] mul(string str1, string str2)
        {
            string[] result = new string[2];
            result[0] = "1";
            result[1] = "2";
            int a1 = Convert.ToInt32(str1, 2);
            int a2 = Convert.ToInt32(str2, 2);
            int a3 = a1 * a2;
            string temp = Convert.ToString(a3, 2);
            if (temp.Length < 8)
            {
                result[1] = "00000000";
                temp = newStr(temp);
                result[0] = temp;
                return result;
            }
            else if (temp.Length > 8)
            {
                result[1] = temp.Substring(0, temp.Length - 8);
                result[1] = newStr(result[1]);
                result[0] = temp.Substring(temp.Length - 8, 8);
                return result;
            }
            return result;
        }
        //寄存器分割，以R为分隔符，返回的字符串数组是寄存器号
        static string[] getThirdSubString(string str)
        {
            string[] tempStr;
            tempStr = str.Split('R');
            return tempStr;
        }
        //单个字符转换为整数
        static int charToInt(char ch)
        {
            int integer = ch - '0';
            //Console.WriteLine(integer);
            return integer;
        }

        //两位char转为十进制
        static int charToInt(char ch1, char ch2)
        {
            int integer = 10 * (ch1 - '0') + (ch2 - '0');
            return integer;
        }
        //整数装换为十六进制
        static string intToHex(int integer)
        {
            return (Convert.ToString(integer, 16));
        }

        //十六进制转换为十进制，一位，形参类型为字符类型
        static int charHexToInt(char ch)
        {
            int integer = 0;
            if (ch == 'A')
            {
                integer = 10;
            }
            else if (ch == 'B')
            {
                integer = 11;
            }
            else if (ch == 'C')
            {
                integer = 12;
            }
            else if (ch == 'D')
            {
                integer = 13;
            }
            else if (ch == 'E')
            {
                integer = 14;
            }
            else if (ch == 'F')
            {
                integer = 15;
            }
            else if ((ch - '0') < 10)
            {
                integer = ch - '0';
            }
            return integer;
        }
        //十六进制转换为十进制，两位形参
        static int charHexToInt(char ch1,char ch2)
        {
            int integer = 16 * charHexToInt(ch1) + charHexToInt(ch2);
            return integer;
        }

        //十六进制转换为十进制，两个形参
        static int hexToInt(char ch, char ch1)
        {
            int integer = 16 * charHexToInt(ch) + 1 * charHexToInt(ch1);
            //Console.WriteLine(integer);
            return integer;
        }

        //十进制转换为二进制,一个形参
        static string intToBinary(int integer)
        {
            string str = Convert.ToString(integer, 2);
            return str;
        }

        //十进制转换为二进制，两个形参
        static string intToBinary(int integer1, int integer2)
        {
            string str = combineStr(Convert.ToString(integer1,2), Convert.ToString(integer2,2));
            return str;
        }
        
        //连接两个字符串函数
        static string combineStr(string str1, string str2)
        {
            string str = str1 + str2;
            return str;
        }

        //给的是一个十六进制字符串
        static string fourCopyStr(string str)
        {
            int n = 4 - str.Length;
            char[] sub = new char[n];
            for (int i = 0; i < n; i++)
            {
                sub[i] = '0';
            }
            string str1 = new string(sub);
            return str1;
        }
        static string fourNewStr(string str)
        {
            str = copyStr(str) + str;
            return str;
        }

        //传入是一个完整的二进制字符串，若不足16位，则返回十六位，外部接口为newHexStr
        static string copyHexStr(string str)
        {
            int n = 16 - str.Length;
            char[] sub = new char[n];
            for (int i = 0; i < n; i++)
            {
                sub[i] = '0';
            }
            string str1 = new string(sub);
            return str1;
        }
        static string newHexStr(string str)
        {
            str = copyHexStr(str) + str;
            return str;
        }
        
        //读入test.data数据
        private void button1_Click(object sender, EventArgs e)
        {
            StreamReader sr = File.OpenText(@"D:\test.data");
            richTextBox1.Text = sr.ReadToEnd();
            instruction = richTextBox1.Lines;
            instructionSum = richTextBox1.Lines.Length;
            //getFistSubString(instruction[0]);
            //Console.WriteLine("instruction is {0}",instruction);
            sr.Close();
        }

        static string getLdString(string str)
        {
            str = getLdAdrString(str);
            string[] tempStr;
            tempStr = str.Split(',');

            //测试经过逗号分割
            //foreach (string i in tempStr)
            //{
            //    Console.Write("经过逗号分割的字符串");
            //    Console.WriteLine(i);
            //}
            return tempStr[0];
        }
        static string getLdAdrString(string str)
        {
            string[] tempStr;
            tempStr = Regex.Split(str, "  ", RegexOptions.IgnoreCase);
            return tempStr[1];
        }
        private void button2_Click(object sender, EventArgs e)
        {
            IR.Text = newHexStr(getIrBinaryString(instruction[stepCount]));
            textBox1.Text = instruction[stepCount];

            //此处tempStr获得是指令码字符串
            string tempStr = getIrString(instruction[stepCount]);
            if ( tempStr == "add")
            {
                string formerBox = getFirstAdr(instruction[stepCount]);
                string formerText = getRegisterText(formerBox);
                string latterBox = getSecondRegister(instruction[stepCount]);
                string latterText = getRegisterText(latterBox);
                string registerText = add(formerText, latterText);
                setRegister(formerBox, registerText);
            }
            else if (tempStr == "sub")
            {
                string formerBox = getFirstAdr(instruction[stepCount]);
                string formerText = getRegisterText(formerBox);
                string latterBox = getSecondRegister(instruction[stepCount]);
                string latterText = getRegisterText(latterBox);
                string registerText = sub(formerText, latterText);
                setRegister(formerBox, registerText);
            }
            else if (tempStr == "Mul")
            {
                string formerBox = getFirstAdr(instruction[stepCount]);
                string formerText = getRegisterText(formerBox);
                string latterBox = getSecondRegister(instruction[stepCount]);
                string latterText = getRegisterText(latterBox);
                string[] result = mul(formerText, latterText);
                setRegister("R0", result[0]);
                setRegister("R1", result[1]);
            }
            else if (tempStr == "RJMP")
            {
                string value = getAdrString(instruction[stepCount]);
                int jumpValue = Convert.ToInt32(value, 16)/2;
                Console.WriteLine("jumpValue is {0}", jumpValue);
                stepCount = stepCount + jumpValue;
            }
                
            else if (instruction[0] == "BRMI")
                tempStr = "11110001";
            else if (tempStr == "Mov")
            {
                Console.WriteLine("这是mov里的");
                string aimRegister = getFirstAdr(instruction[stepCount]);
                //Console.WriteLine("aimRegt")
                string operationRegister = getSecondRegister(instruction[stepCount]);
                Console.WriteLine("获得的第二个寄存器的寄存器号是{0}", operationRegister);
                string registerText = getRegisterText(operationRegister);
                setRegister(aimRegister, registerText);
            }
            else if (tempStr == "Ldi")
            {
                setRegister(getFirstAdr(instruction[stepCount]), getSecondAdr(instruction[stepCount]));
                Console.WriteLine("这是button2单步调试的点击事件吗，ldi 指令执行完了");
            }
            // tempStr = "1110";
            else if (tempStr == "Ld")
            {
                //string registerName = getFirstAdr(instruction[stepCount]);
                //registerName = "R13";
                string registerName1 = getLdString(instruction[stepCount]);
                Console.WriteLine("ld前个寄存器的是{0}什么呢", registerName1);
                string registerText = R14.Text;
                setRegister(registerName1, registerText);
            }
            else if (tempStr == "st")
            {
                string register2 = getSecondRegister(instruction[stepCount]);
                string register2Txt = getRegisterText(register2);
                setRegister("R14", register2Txt);
            }
            else if (tempStr == "nop")
                MessageBox.Show("执行了nop指令，不做任何操作，只消耗cpu时间", "信息提示", MessageBoxButtons.OK, MessageBoxIcon.Information);

            stepCount++;
            //PC.Text =  intToBinary(stepCount);
            PC.Text = newHexStr(intToBinary(stepCount));
            if (stepCount < richTextBox1.Lines.Length)
                textBox2.Text = instruction[stepCount];
            else textBox2.Text = "无，以执行当前文件的所有指令，执行完当前文件的所有指令";
            //instructionSum = richTextBox1.Lines.Length;
            //string[] outputTxt = new string[instructionSum];

            
            //foreach (Control c in this.Controls)
            //{
            //    if (c is TextBox && c.Name == "r15")
            //    {
            //        TextBox temp = c as TextBox;
            //        temp.Text = "chenggongla";
            //    }
            //}

            
        }

        private void r2_TextChanged(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            for (; stepCount < richTextBox1.Lines.Length; stepCount++)
            {
                IR.Text = newHexStr(getIrBinaryString(instruction[stepCount]));
                textBox1.Text = instruction[stepCount];

                //此处tempStr获得是指令码字符串
                string tempStr = getIrString(instruction[stepCount]);
                if (tempStr == "add")
                {
                    string formerBox = getFirstAdr(instruction[stepCount]);
                    string formerText = getRegisterText(formerBox);
                    string latterBox = getSecondRegister(instruction[stepCount]);
                    string latterText = getRegisterText(latterBox);
                    string registerText = add(formerText, latterText);
                    setRegister(formerBox, registerText);
                }
                else if (tempStr == "sub")
                {
                    string formerBox = getFirstAdr(instruction[stepCount]);
                    string formerText = getRegisterText(formerBox);
                    string latterBox = getSecondRegister(instruction[stepCount]);
                    string latterText = getRegisterText(latterBox);
                    string registerText = sub(formerText, latterText);
                    setRegister(formerBox, registerText);
                }
                else if (tempStr == "Mul")
                {
                    string formerBox = getFirstAdr(instruction[stepCount]);
                    string formerText = getRegisterText(formerBox);
                    string latterBox = getSecondRegister(instruction[stepCount]);
                    string latterText = getRegisterText(latterBox);
                    string[] result = mul(formerText, latterText);
                    setRegister("R0", result[0]);
                    setRegister("R1", result[1]);
                }
                else if (tempStr == "RJMP")
                {
                    string value = getAdrString(instruction[stepCount]);
                    int jumpValue = Convert.ToInt32(value, 16) / 2;
                    Console.WriteLine("jumpValue is {0}", jumpValue);
                    stepCount = stepCount + jumpValue;
                }

                else if (instruction[0] == "BRMI")
                    tempStr = "11110001";
                else if (tempStr == "Mov")
                {
                    Console.WriteLine("这是mov里的");
                    string aimRegister = getFirstAdr(instruction[stepCount]);
                    //Console.WriteLine("aimRegt")
                    string operationRegister = getSecondRegister(instruction[stepCount]);
                    Console.WriteLine("获得的第二个寄存器的寄存器号是{0}", operationRegister);
                    string registerText = getRegisterText(operationRegister);
                    setRegister(aimRegister, registerText);
                }
                else if (tempStr == "Ldi")
                {
                    setRegister(getFirstAdr(instruction[stepCount]), getSecondAdr(instruction[stepCount]));
                    Console.WriteLine("这是button2单步调试的点击事件吗，ldi 指令执行完了");
                }
                // tempStr = "1110";
                else if (tempStr == "Ld")
                {
                    //string registerName = getFirstAdr(instruction[stepCount]);
                    //registerName = "R13";
                    string registerName1 = getLdString(instruction[stepCount]);
                    Console.WriteLine("ld前个寄存器的是{0}什么呢", registerName1);
                    string registerText = R14.Text;
                    setRegister(registerName1, registerText);
                }
                else if (tempStr == "st")
                {
                    string register2 = getSecondRegister(instruction[stepCount]);
                    string register2Txt = getRegisterText(register2);
                    setRegister("R14", register2Txt);
                }
                else if (tempStr == "nop")
                    MessageBox.Show("执行了nop指令，不做任何操作，只消耗cpu时间", "信息提示", MessageBoxButtons.OK, MessageBoxIcon.Information);

                
                //PC.Text =  intToBinary(stepCount);
                PC.Text = newHexStr(intToBinary(stepCount));
                if (stepCount < richTextBox1.Lines.Length)
                    textBox2.Text = instruction[stepCount];
                else textBox2.Text = "无，以执行当前文件的所有指令，执行完当前文件的所有指令";
                //instructionSum = richTextBox1.Lines.Length;
                //string[] outputTxt = new string[instructionSum];


                //foreach (Control c in this.Controls)
                //{
                //    if (c is TextBox && c.Name == "r15")
                //    {
                //        TextBox temp = c as TextBox;
                //        temp.Text = "chenggongla";
                //    }
                //}

            }
            textBox2.Text = "无，以执行当前文件的所有指令，执行完当前文件的所有指令";
        }

        private void label21_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            MessageBox.Show("老师您好，在您开始测试之前请确保：1.测试文件为test.data并放在D盘根目录下；2.在您点击单步执行或同步执行之前，请先点击导入文件。3.确定您的Ld指令分隔符为两个空格，但其他的分割为一个空格。老师辛苦了，谢谢您", "使用提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
    }
}
