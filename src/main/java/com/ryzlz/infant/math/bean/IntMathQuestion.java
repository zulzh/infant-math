package com.ryzlz.infant.math.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class IntMathQuestion {
    //数字1起始
    private int numOneFrom;
    //数字1结束
    private int numOneEnd;
    //数字2起始
    private int numTwoFrom;
    //数字2结束
    private int numTwoEnd;
    //结果
    private int result;
    //最大结果
    private int resultMax;
    //操作符 1:+  2:-  3:* 4:/
    private List<Integer> operator;
    //题目模式
    private int printType;

    //是否可以为负数
    private boolean isMinus = false;

    //默认模式
    public final static  int COMMON_PRINT_TYPE = 0;
    //有括号模式
    public final static  int FILL_PRINT_TYPE = 1;
    //+号
    public final static  int OPERATOR_ADD = 1;
    //-号
    public final static  int OPERATOR_SUB = 2;


    //取得问题
    public String getQuestion() throws Exception {

        String resultString = "";

        //1.1 取得填空位
        int index = 2;
        switch (getPrintType()){
            case FILL_PRINT_TYPE:
                 index = getRandom(0,2);
                break;
            case COMMON_PRINT_TYPE:
                 index = 2;
                break;
        }


        int numOne = getRandom(getNumOneFrom(),getNumOneEnd());

        int numTwo = 0;
        int result = 0;

        //取得数字1
        numOne = getRandom(getNumOneFrom(),getNumOneEnd());

        //取得操作符
        Operator operator = getOperatorData();

        if(operator.getType() == OPERATOR_ADD){

            numTwo = getRandom(getNumTwoFrom(),resultMax-numOne);
            result = numOne + numTwo;
        }

        if(operator.getType() == OPERATOR_SUB){
            if(isMinus){
                numTwo = getRandom(getNumTwoFrom(),getNumTwoEnd());
            }else {
                numTwo = getRandom(getNumTwoFrom(),numOne);
            }
            result = numOne - numTwo;
        }

        //1.2 取得数字1
        switch (index){
            case 0:
                resultString += "(&nbsp;&nbsp;&nbsp;&nbsp;)"+ operator.getOperator()+ " "+numTwo+" "+ " = " +" "+result+" ";
                break;
            case 1:
                resultString += " "+numOne+" "+ operator.getOperator()+ "(&nbsp;&nbsp;&nbsp;&nbsp;)" + " = " +" "+result+" ";
                break;
            case 2:
                resultString += " "+numOne+" "+ operator.getOperator()+ " "+numTwo+" " + " = " +"(&nbsp;&nbsp;&nbsp;&nbsp;)";
                break;
        }

        return resultString;
    }

    //取得操作符
    private Operator getOperatorData() throws Exception {
        Operator resultOperator = new Operator();
        if(operator!=null && operator.size()>0){
            int index = getRandom(0,operator.size()-1);
            switch (operator.get(index)){
                case OPERATOR_ADD :
                    resultOperator.setOperator(" + ");
                    resultOperator.setType(OPERATOR_ADD);
                    break;
                case OPERATOR_SUB :
                    resultOperator.setOperator(" - ");
                    resultOperator.setType(OPERATOR_SUB);
                    break;

            }
        }else {
            throw new Exception("操作符为空");
        }

        return resultOperator;
    }

    private int getRandom(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min; //  将被赋值为一个 MIN 和 MAX 范围内的随机数
    }


}
