public class MyArrList {
    private int[] elem;
    private int usedSize;

    public MyArrList(){
        this.elem = new int[10];
    }

    public MyArrList(int ret){
        this.elem = new int[ret];
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
    }

    //判断是否为满
    public boolean isFull(){
        if(this.usedSize == this.elem.length){
            return true;
        }
        return false;
    }
    //在pos位置新增元素
    public void add(int pos,int data){
        if(isFull()){
            System.out.println("顺序表为满！");
            return;
        }
        if(pos < 0 || pos > this.usedSize){
            System.out.println("无pos位置！");
        }
        for(int i = this.usedSize - 1; i >= pos; i--){
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        int i;
        for(i = 0; i < this.usedSize; i++){
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        int i;
        for(i = 0; i < this.usedSize; i++){
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    // 获取顺序表长度
    public int size() {
        int count = 0;
        for(int i = 0; i < this.usedSize; i++){
            count++;
        }
        return count;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos < 0 || pos > this.usedSize){
            System.out.println("pos位置不存在！");
            return -1;
        }else{
            int i,ret;
            for(i = 0; i < this.usedSize; i++){
                if(this.elem[i] == this.elem[pos]){
                    ret = this.elem[pos];
                    return ret;
                }
            }
        }
        return -1;
    }

    // 给 pos 位置的元素修改为 value
    public void setPos(int pos, int value) {
        if(pos < 0 || pos > this.usedSize){
            System.out.println("pos位置不存在！");
            return;
        }else{
            this.elem[pos] = value;
        }

    }
    //删除元素
    public void remove(int key){
        int i,j = 0;
        for(i = 0; i < this.usedSize; i++){
            if(this.elem[i] == key){
                j = i;
                break;
            }
        }
        for(i = j; i < this.usedSize - 1; i++){
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }

    public static void main(String[] args){
        MyArrList myArr = new MyArrList();
        //MyArrList myArr1 = new MyArrList(20);
        myArr.add(0,5);
        myArr.add(1,15);
        myArr.add(2,35);
        myArr.add(3,45);
        myArr.display();
        System.out.println();
        myArr.setPos(1,88);
        myArr.display();
        System.out.println();
        System.out.println(myArr.getPos(2));
        //System.out.println(myArr.search(15));
    }
}
