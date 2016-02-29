import java.io.*;
import java.util.Scanner;
class KeyExpansion
{
	static int[] decimal(String x)
	{
		char[] ch=x.toCharArray();
		int l=x.length();
		int[] dec=new int[l];
		for(int i=0;i<l;i++)
		{
			dec[i]=Character.digit(ch[i],16);
		}
		return dec;
	}
	static String xor(String x,String y)
	{
		int l=x.length();
		int x1[]=new int[l];
		int y1[]=new int[l];
		x1=decimal(x);
		y1=decimal(y);
		int[] z1=new int[l];
		for(int i=0;i<l;i++)
		{
			z1[i]=x1[i]^y1[i];
		}
		String z="";
		for(int i=0;i<l;i++)
		{
			z=z+Integer.toHexString(z1[i]);
		}
		return z;
	}
	static String rotword(String x)
	{
		char[] ch1=x.toCharArray();
		char y=ch1[0];
		char z=ch1[1];
		String z1="";
		String z2="";
		z2=y+"";
		z2=z2+z;
		char y1;
		for(int i=0;i<7;i++)
		{
			if(i<6)
			{
				y1=ch1[i+2];
				z1=z1+y1;
			}
			else
			{
				z1=z1+z2;
			}
		}
		return z1;
	}
	static void print(int[] x)
	{
		for(int i=0;i<x.length;i++)
			{
				System.out.print(x[i]+" ");
			}
			System.out.println();
	}
	static String sbox(int x,int y)
	{
		String[][] s =
		
					{
						{
							//Row0
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"63","7c","77","7b","f2","6b","6f","c5","30","01","67","2b","fe","d7","ab","76"
						}, 
						{
							//Row1
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"ca","82","c9","7d","fa","59","47","f0","ad","d4","a2","af","9c","a4","72","c0"
						},
						{
							//Row2
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"b7","fd","93","26","36","3f","f7","cc","34","a5","e5","f1","71","d8","31","15"
						},
						{
							//Row3
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"04","c7","23","c3","18","96","05","9a","07","12","80","e2","eb","27","b2","75"
						},
						{
							//Row4
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"09","83","2c","1a","1b","6e","5a","a0","52","3b","d6","b3","29","e3","2f","84"
						},
						{
							//Row5
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"53","d1","00","ed","20","fc","b1","5b","6a","cb","be","39","4a","4c","58","cf"
						},
						{
							//Row6
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"d0","ef","aa","fb","43","4d","33","85","45","f9","02","7f","50","3c","9f","a8"
						},
						{
							//Row7
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"51","a3","40","8f","92","9d","38","f5","bc","b6","da","21","10","ff","f3","d2"
						},
						{
							//Row8
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"cd","0c","13","ec","5f","97","44","17","c4","a7","7e","3d","64","5d","19","73"
						},
						{
							//Row9
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"60","81","4f","dc","22","2a","90","88","46","ee","b8","14","de","5e","0b","db"
						},
						{
							//RowA
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"e0","32","3a","0a","49","06","24","5c","c2","d3","ac","62","91","95","e4","79"
						},
						{
							//RowB
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"e7","c8","37","6d","8d","d5","4e","a9","6c","56","f4","ea","65","7a","ae","08"
						},
						{
							//RowC
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"ba","78","25","2e","1c","a6","b4","c6","e8","dd","74","1f","4b","bd","8b","8a"
						},
						{
							//RowD
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"70","3e","b5","66","48","03","f6","0e","61","35","57","b9","86","c1","1d","9e"
						},
						{
							//RowE
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"e1","f8","98","11","69","d9","8e","94","9b","1e","87","e9","ce","55","28","df"
						},
						{
							//RowF
							//0   1    2    3    4    5    6    7    8    9    A    B    C    D    E    F
							"8c","a1","89","0d","bf","e6","42","68","41","99","2d","0f","b0","54","bb","16"
						}
					};
		return s[x][y];
	}
	static String subword2(String x)
	{
		char[] ch=x.toCharArray();
		int v1=0;
		String z="";
		String y="";
		int num,num1;
		num=Character.digit(ch[v1],16);
		num1=Character.digit(ch[v1+1],16);		
		z=sbox(num,num1);
		y=y+z;
		return y;
	}
	static String subword(String x)
	{
		//System.out.println("hi");
		char[] ch=x.toCharArray();
		int v1=0;
		String z="";
		String y="";
		int num,num1;
		for(int i=0;i<4;i++)
		{	
			num=Character.digit(ch[v1],16);
			num1=Character.digit(ch[v1+1],16);		
			z=sbox(num,num1);
			y=y+z;
			v1=v1+2;
		}
		return y;
	}
	static String rcon(int x)
	{
		String[] rc = {
						"01","02","04","08","10","20","40","80","1b","36"
					  };
		return rc[x-1];
	}
	static String[] function()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the Key:");
		String str=in.next();
		char[] ch=str.toCharArray();
		int l=str.length();
		int v=0;
		String[] x=new String[16];
		String x1,x2;
		for(int i=0;i<16;i++)
		{
			x1=ch[v]+"";
			v++;
			x2=ch[v]+"";
			v++;
			x[i]=x1+x2;						
		}
		String[] w=new String[44];
		System.out.println("Key Matrix:");
		for(int i=0;i<16;i=i+4)
		{
			System.out.println(x[i]+"\t"+x[i+1]+"\t"+x[i+2]+"\t"+x[i+3]);
		}
		for(int i=0;i<4;i++)
		{
			w[i]=x[4*i]+x[(4*i)+1]+x[(4*i)+2]+x[(4*i)+3];
		}
		for(int i=0;i<4;i++)
		{
			System.out.println("W["+i+"]:"+w[i]);
		}
		String r,rot,sub,temp;
		for(int i=4;i<44;i++)
		{
			temp=w[i-1];
			if(i%4==0)
			{
				r=rcon(i/4);
				rot=rotword(temp);
				System.out.println("Rotational word:"+rot);
				sub=subword(rot);
				System.out.println("Subword:"+sub);
				r=r+"000000";
				temp=xor(sub,r);
			}
			w[i]=xor(w[i-4],temp);
			System.out.println("w["+i+"]:"+w[i]);
		}
		return w;
	}
}
class aes
{
	static int[] binary(int[] x)
	{
		int[] bin=new int[8];
		int v;
		for(int i=0;i<2;i++)
		{
			if(i==0)
			{
				v=3;
				while(x[i]>1)
				{
					bin[v]=x[i]%2;
					x[i]=x[i]/2;
					v--;
				}
			}
			else
			{
				v=7;
				while(x[i]>1)
				{
					bin[v]=x[i]%2;
					x[i]=x[i]/2;
					v--;
				}
			}			
		}
		return bin;
	}	
	static int[] xor1(int[] x,int[] y)
	{
		int[] z=new int[8];
		for(int i=0;i<8;i++)
		{
			z[i]=x[i]^y[i];
		}
		return z;
	}
	static int[] leftshift(int[] x)
	{
		int temp=x[0];
		int[] y=new int[8];
		for(int i=0;i<8;i++)
		{
			if(i==7)
			{
				y[i]=0;
			}
			else
			{
				y[i]=x[i+1];
			}
		}
		int[] c={0,0,0,1,1,0,1,1};
		if(temp==1)
		{
			y=xor1(y,c);
		}
		return y;
	}
	static String hexadecimal(int[] x)
	{
		String hex="";
		for(int i=0;i<x.length;i++)
		{
			hex=hex+x[i];
		}
		int i= Integer.parseInt(hex,2);
  		String hexString = Integer.toHexString(i);
  		return hexString;
	}
	static void print(int[] x)
	{
		for(int i=0;i<x.length;i++)
			{
				System.out.print(x[i]+" ");
			}
			System.out.println();
	}
	static int[] hexToBin(String a)
	{
		String temp = "";
		for(int i=0;i<a.length();i++)
		{
			switch(a.charAt(i))
			{
				case '0' : temp = temp + "0000"; break;
				case '1' : temp = temp + "0001"; break;
				case '2' : temp = temp + "0010"; break;
				case '3' : temp = temp + "0011"; break;
				case '4' : temp = temp + "0100"; break;
				case '5' : temp = temp + "0101"; break;
				case '6' : temp = temp + "0110"; break;
				case '7' : temp = temp + "0111"; break;
				case '8' : temp = temp + "1000"; break;
				case '9' : temp = temp + "1001"; break;
				case 'A' : temp = temp + "1010"; break;
				case 'a' : temp = temp + "1010"; break;
				case 'B' : temp = temp + "1011"; break;
				case 'b' : temp = temp + "1011"; break;
				case 'C' : temp = temp + "1100"; break;
				case 'c' : temp = temp + "1100"; break;
				case 'D' : temp = temp + "1101"; break;
				case 'd' : temp = temp + "1101"; break;
				case 'E' : temp = temp + "1110"; break;
				case 'e' : temp = temp + "1110"; break;
				case 'F' : temp = temp + "1111"; break;
				case 'f' : temp = temp + "1111"; break;
			}
		}
		int[] output = new int[temp.length()];
		for(int i=0;i<output.length;i++)
		{
			output[i] = (int)(temp.charAt(i)-'0');
		}
		return output;
	}
	static String multiply(String a,String b,KeyExpansion obj)
	{
		int[] y=hexToBin(a);
		int[] x=hexToBin(b);
		int[][] temp=new int[2][8];
		int[] sum=new int[8];
		int v=0;
		for(int i=7;i>=6;i--)
		{
			if(i==7)
			{
				if(y[i]==1)
				{
					temp[v]=x;
				}				
			}
			else
			{
				if(y[i]==1)
				{
					temp[v]=leftshift(x);
				}
			}
			v++;
		}
		for(int i=0;i<2;i++)
		{
			sum=xor1(sum,temp[i]);
		}
		int[] sum1=new int[4];
		int[] sum2=new int[4];
		for(int i=0;i<4;i++)
		{
			sum1[i]=sum[i];
		}
		for(int i=0;i<4;i++)
		{
			sum2[i]=sum[i+4];
		}
		String str=hexadecimal(sum1)+hexadecimal(sum2);
		return str;

	}
	static String rightshift(String x)
	{
		char[] ch=x.toCharArray();
		char a=ch[0];
		char b=ch[1];
		String y="";
		for(int i=2;i<ch.length;i++)
		{
			y=y+ch[i];
		}
		y=y+a+b;
		return y;
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		KeyExpansion e = new KeyExpansion();
		String[] w1=e.function();
		String[][] start=new String[4][4];				
		for(int i=0;i<4;i++)
		{
			int v=0;
			char[] ch=w1[i].toCharArray();
			for(int j=0;j<4;j++)
			{
				char a=ch[v];
				char b=ch[v+1];
				String x="";
				x=x+a;
				x=x+b;
				start[j][i]=x;
				v=v+2;
			}
		}
		System.out.println("Round key:");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(start[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Enter the plain Text:");
		String plain=in.next();
		char[] ch1=plain.toCharArray();
		String plaintxt[][] = new String [4][4];
		int v=0;
		for(int i=0;i<4;i++)
		{			
			for(int j=0;j<4;j++)
			{
				String x="";
				x=x+ch1[v];
				x=x+ch1[v+1];
				plaintxt[j][i]=x;
				v=v+2;
			}			
		}
		System.out.println("Start of Round:");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(plaintxt[i][j]+" ");
			}
			System.out.println();
		}
		int var=4;
		String[][] mix=new String[4][4];
		// ROUND 1
		for(int round=0;round<10;round++)
		{
			
			System.out.println("*******************Round:"+(round+1)+"********************");
			System.out.println("Start for round:");
			if(round==0)
			{
				for(int i=0;i<4;i++)
				{
					for(int j=0;j<4;j++)
					{
						plaintxt[i][j]=e.xor(start[i][j],plaintxt[i][j]);
						System.out.print(plaintxt[i][j]+" ");
					}
					System.out.println();
				}
			}	
			else
			{
				for(int i=0;i<4;i++)
				{
					for(int j=0;j<4;j++)
					{
						plaintxt[i][j]=e.xor(start[i][j],mix[i][j]);
						System.out.print(plaintxt[i][j]+" ");
					}
					System.out.println();
				}
			}		
			String[][] sub=new String[4][4];
			System.out.println("Sub bytes Round:");
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					sub[i][j]=e.subword2(plaintxt[i][j]);
					System.out.print(sub[i][j]+" ");
				}
				System.out.println();
			}
			String[][] shift=new String[4][4];
			System.out.println("Shift Rows:");
			for(int i=0;i<4;i++)
			{
				String x="";
				if(i==0)
				{
					for(int j=0;j<4;j++)
					{
						shift[i][j]=sub[i][j];
					}
				}
				else
				{
					String str="";
					for(int j=0;j<4;j++)
					{				
						str=str+sub[i][j];
					}		
					x=str;	
					for(int k=0;k<i;k++)
					{
						x=rightshift(x);
					}	
					int v1=-2;
					char[] y=x.toCharArray();
					for(int k=0;k<4;k++)
					{
						v1=v1+2;
						String z="";
						z=z+y[v1]+y[v1+1];
						shift[i][k]=z;
					}							
				}
			}
			//System.out.println("\n"+"After Shift Rows:");
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					System.out.print(shift[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("Mix Columns:");
			String[][] c={{"02","03","01","01"},{"01","02","03","01"},{"01","01","02","03"},{"03","01","01","02"}};
			String s="00";
			String temp="";
			
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					for(int k=0;k<4;k++)
					{
						temp=multiply(c[i][k],shift[k][j],e);
						s=e.xor(s,temp);
					}
					mix[i][j]=s;
					s="00";
				}
			}
			//System.out.println("After doing Mix Columns :");
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					System.out.print(mix[i][j]+" ");
				}
				System.out.println();
			}
			//Round key ( start matrix )
			for(int i=0;i<4;i++)
			{
				int v1=0;
				char[] ch=w1[var+i].toCharArray();
				for(int j=0;j<4;j++)
				{
					char a=ch[v1];
					char b=ch[v1+1];
					String x="";
					x=x+a;
					x=x+b;
					start[j][i]=x;
					v1=v1+2;
				}
			}
			var=var+4;
			System.out.println("Round key:");
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					System.out.print(start[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}