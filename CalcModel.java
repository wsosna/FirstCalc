package mainpack;

import javax.swing.*;
import java.util.Stack;

public class CalcModel {
    private ControlerCalc controler;
    private Stack<Integer> stackNum;
    private Stack <String> stackOperations;

    public CalcModel (ControlerCalc controler){
        this.controler = controler;
        stackNum = new Stack<Integer>();
        stackOperations = new Stack<String>();
    }

    public void pushToNumbers (){
        stackNum.push(Integer.parseInt(controler.getCalcFrame().getjTextField().getText()));
    }
    public void pushToOperations (JButton button){
        stackOperations.push(button.getText());
    }

    public Stack<String> getStackOperations() {
        return stackOperations;
    }
    public Stack<Integer> getStackNum() {
        return stackNum;
    }
}
