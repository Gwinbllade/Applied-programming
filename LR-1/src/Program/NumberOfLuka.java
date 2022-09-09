package Program;

/**
 * Клас для опису чисел з послідовності Люка
 * @author Ihor Bychkovskyi "ihor.bychkovskyi.kn.2021@lpnu.ua"
 * @version 1.0
 */

public class NumberOfLuka {
    /**Поле для зберження кільскості створених об'єктів */
    private static int numberOfDigits = 0;
    /**Поле для зберження порядкового номеру числа в послідовності Люка */
    private  int sequenceNumber;
    /**Значення числа*/
    private int value;
    /** Поле для перевірки чи число є квадратом*/
    private boolean isSquare ;


    NumberOfLuka(int number){
        this.sequenceNumber =  ++this.numberOfDigits;
        this.value = number;
        this.isSquare = false;
    }

    public  int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public int getValue() {
        return value;
    }

    public boolean getIsSquare() {
        return isSquare;
    }

    public void setIsSquare(boolean isSquare) {
        this.isSquare = isSquare;
    }

    /**
     * @return Рядок інформації про об'єкт
     * */
    public String toString(){
        return String.format("Value:%d - Sequence Number:%d ",this.value,this.sequenceNumber );
    }
}
