package mainpack;


import javax.swing.*;

public class ControlerCalc {

    CalcFrame calcFrame;
    CalcModel calcModel;

    public ControlerCalc(){
        this.calcFrame = new CalcFrame(this);
        this.calcModel = new CalcModel(this);
    }

    public void operationButtonAction (JButton button) throws CalcsException{
        if (!calcFrame.getjTextField().getText().isEmpty()) {
            calcModel.pushToNumbers();
            calcFrame.getjTextField().setText("");
            calcModel.pushToOperations(button);
        }else throw new CalcsException();
    }

    public void equalButtonAction () throws CalcsException{
        if (!calcFrame.getjTextField().getText().isEmpty()) {
            calcModel.pushToNumbers();
            calcFrame.getjTextField().setText("" + equal());
        }else throw new CalcsException();
    }

    public void refrashButtonAction (){
        calcFrame.getjTextField().setText("");
        while (!calcModel.getStackNum().isEmpty() && !calcModel.getStackOperations().isEmpty()){
            calcModel.getStackNum().pop();
            calcModel.getStackOperations().pop();
        }
    }

    public int equal (){
        while (!calcModel.getStackOperations().isEmpty()) {
            switch (calcModel.getStackOperations().pop()) {
                case "+":
                    calcModel.getStackNum().push(calcModel.getStackNum().pop() + calcModel.getStackNum().pop());
                    break;
                case "-":
                    int a = calcModel.getStackNum().pop();
                    int b = calcModel.getStackNum().pop();
                    calcModel.getStackNum().push(b - a);
                    break;
            }
        }
        return calcModel.getStackNum().pop();
    }

    public CalcFrame getCalcFrame() {
        return calcFrame;
    }
}
