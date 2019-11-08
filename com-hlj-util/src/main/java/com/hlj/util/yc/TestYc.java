package com.hlj.util.yc;


/*�������˹����ܽ�,��ӭ����ָ��*/

/*�Զ����쳣*/
class ChushulingException extends Exception
{
    public ChushulingException(String msg)
    {
        super(msg);
    }
}

class ChushufuException extends Exception
{
    public ChushufuException(String msg)
    {
        super(msg);
    }
}

/*�Զ����쳣 End*/

class Numbertest
{
    public int shang(int x,int y) throws ChushulingException,ChushufuException
    {
        if(y<0)
        {
            throw new ChushufuException("���������"+y+",�涨��������Ϊ����!");//�׳��쳣  �����쳣����Ϣ
        }
        if(y==0)
        {
            throw new ChushulingException("���������"+y+",��������Ϊ0!");
        }

        int m=x/y;
        return m;
    }
}


public class TestYc
{
    public static void main(String[]args)
    {
        Numbertest n=new Numbertest();

        //�����쳣
        try
        {
            System.out.println("��="+n.shang(1,-3));
        }
        catch(ChushulingException yc)
        {
            System.out.println(yc.getMessage());
            yc.printStackTrace();
        }
        catch(ChushufuException yx)
        {
            System.out.println(yx.getMessage()+"hello");
           yx.printStackTrace();
        }
        catch(Exception y)
        {
            System.out.println(y.getMessage());
            y.printStackTrace();
        }

    finally{ System.out.println("finally!");} ////finally���ܷ�û�����쳣���ᱻִ��
        System.out.println("����");
    }
}
/*
[�ܽ�]

1.�Զ����쳣:

class �쳣���� extends Exception
{
    public �쳣����(String errMsg)
    {
        super(errMsg);
    }
}

2.��ʶ�����׳����쳣:

throws �쳣����1,�쳣����2

3.�����쳣:
try{}
catch(�쳣���� y){}
catch(�쳣���� y){}

4.��������
getMessage() //����쳣����Ϣ
printStackTrace() //��������쳣��Ϊ��ϸ����Ϣ


*/
