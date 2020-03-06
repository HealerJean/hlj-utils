package com.hlj.util.Z024_深复制浅复制;

class StudentLow implements Cloneable{
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() {
        StudentLow stu = null;
        try{
            stu = (StudentLow)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}
