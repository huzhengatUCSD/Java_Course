package ch10;

import java.util.regex.Pattern;


public class RegularExTester
{
	public static void main(String[] args) {
		
		System.out.println("Java Java Java".replaceAll("v\\w", "WI"));
		System.out.println("Java Java Java;".replaceAll("a\\W", "wi"));
		String[] s = "Java1HTML12345677Perl".split("\\d");
		for(int i=0;i<s.length;i++){
			System.out.print(s[i]+" ");
		}
		System.out.println("\r\n   ------ ======== -------  ");

		// 把字符串种的"aaa"全部替换为"z"
		// 打印zbzcz
		System.out.println("aaaabaaacaaa".replaceAll("a{3}", "z"));

		// 把字符串中的"aaa"、"aa"或者"a"全部替换为"*"
		// 打印*b*c*
		System.out.println("aaaabaaacaada".replaceAll("a+", "\\*"));

		// 把字符串中的数字全部替换为"z"
		// 打印zzzazzbzzcc
		System.out.println("123a44b35cc".replaceAll("\\d", "z"));

		// 把字符串中的非数字全部替换为"0"
		// 打印1234000435000
		System.out.println("1234abc435def".replaceAll("\\D", "0"));

		// 把字符串中的"."全部替换为"\"
		// 打印com\abc\dollapp\Doll
		System.out.println("com.abc.dollapp.Doll".replaceAll("\\.", "\\\\"));

		// 把字符串中的"a.b"全部替换为"-"
		// "a.b"表示长度为3的字符串，以"a"开头，以"b"结尾
		// 打印-hello-all
		System.out.println("azbhelloahball".replaceAll("a.b", "-"));

		// 把字符串中的所有词字符替换为"#"
		// 正则表达式"[a-zA-Z_0-9]"等价于是"\w"
		// 打印#.#.#.#.#.#.#
		System.out.println("a.b.c.1.2.3.4".replaceAll("[a-zA _0-9]", "#"));

		//把手机号中间四位数字替换为"*"
		String tel = "17800001234";//138****1111;
		tel = tel.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1****$3");
		System.out.println(tel);

		//判断邮箱地址是否正确

		String mail_regex = "[a-zA-Z0-9]+([\\_\\+\\.\\-]?[A-Za-z0-9]+)*\\w*@[a-zA-Z0-9]+(\\.\\w+)+";

		String strMail = "huzheng.fdasf@gmail.com.cn.cn.cn.cn.cn";
		System.out.println("is strMail a Mail address :"
				+ strMail.matches(mail_regex));


 // http://www.adfjadf.com/fasdf.html? ftp  url 

	}
}
