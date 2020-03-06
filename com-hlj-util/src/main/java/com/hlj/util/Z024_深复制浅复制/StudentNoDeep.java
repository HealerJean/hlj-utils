package com.hlj.util.Z024_深复制浅复制;


class AddressNo {
    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

}

class StudentNoDeep implements Cloneable{
    private int number;

    private AddressNo addr;

    public AddressNo getAddr() {
        return addr;
    }

    public void setAddr(AddressNo addr) {
        this.addr = addr;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() {
        StudentNoDeep stu = null;
        try{
            stu = (StudentNoDeep)super.clone();  //ǳ����
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}
