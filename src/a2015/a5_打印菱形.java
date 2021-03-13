package a2015;
/*
 * 5.打印菱形

给出菱形的边长，在控制台上打印出一个菱形来。
为了便于比对空格，我们把空格用句点代替。
当边长为8时，菱形为：
.......*
......*.*
.....*...*
....*.....*
...*.......*
..*.........*
.*...........*
*.............*
.*...........*
..*.........*
...*.......*
....*.....*
.....*...*
......*.*
.......*

下面的程序实现了这个功能，但想法有点奇怪。
请仔细分析代码，并填写划线部分缺失的代码。
注意，只能填写缺少的部分，不要重复抄写已有代码。不要填写任何多余的文字。

答案:s.substring(0, s.length()-3),
看懂代码后会发现它先构造最长的那行，把n=8带入就看懂代码了
 */
public class a5_打印菱形 {

    public static void f(int n)
    {
        String s = "*";
        for(int i=0; i<2*n-3; i++) s += ".";
        s += "*";
    
        String s1 = s + "\n";
        String s2 = "";
        
        for(int i=0; i<n-1; i++){
            //System.out.println("=>"+s);
      //      s = "." + _____________________________________ + "*";  //填空
            s1 = s + "\n" + s1;
            s2 += s + "\n";
        }
        System.out.println(s1+s2);        
    }
    
    public static void main(String[] args)
    {
        f(8);
    }

}
