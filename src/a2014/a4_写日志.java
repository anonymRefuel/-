package a2014;
/*
 * 4.标题：写日志
    写日志是程序的常见任务。现在要求在 t1.log, t2.log, t3.log 三个文件间轮流写入日志。
    也就是说第一次写入t1.log，第二次写入t2.log，... 第四次仍然写入t1.log，如此反复。
    下面的代码模拟了这种轮流写入不同日志文件的逻辑。
    
请填写划线部分缺失的代码。通过浏览器提交答案。
注意：不要填写题面已有的内容，也不要填写任何说明、解释文字。

1 + n%3  ,求模操作，可以把n=1,2,3代进去验证
 */
public class a4_写日志 {
	
		private static int n = 1;
		
		public static void write(String msg)
		{
			String filename = "t" + n + ".log";
		//	n = ____________;
			System.out.println("write to file: " + filename + " " + msg);
		}
	
}
