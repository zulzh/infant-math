package com.ryzlz.infant.math.controller;

import com.ryzlz.infant.math.bean.IntMathQuestion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class IntMathQuestionController {
    @RequestMapping("/")
    public String index(Model model) {

        List<Integer> operator = new ArrayList<>();
        operator.add(IntMathQuestion.OPERATOR_ADD);
        operator.add(IntMathQuestion.OPERATOR_SUB);
        IntMathQuestion intMathQuestion = new IntMathQuestion(0,9,
                0,9,0,10,operator,IntMathQuestion.FILL_PRINT_TYPE,false);


        List<String> questionList = new ArrayList<>();

        for(int i=0;i<72*10;i++){
            try {
                questionList.add(intMathQuestion.getQuestion());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("questionList", questionList);



        return "index";
    }

}
