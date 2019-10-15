package DataFrame;

class COOValue {
    private int key;
    private Object value;

    COOValue(int key, Object value){
        this.key = key;
        this.value = value;
    }

    void printCOOValue(){
        System.out.print("|\t(" + this.key + ", " + this.value + ")\t|");
    }

    int getKey(){
        return this.key;
    }

    Object getValue(){
        return this.value;
    }
}
