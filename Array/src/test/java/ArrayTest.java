import entity.DynamicArray;
import org.junit.Test;

public class ArrayTest {

    @Test
    public void dynamicArrayTest(){
        DynamicArray dynamicArray=new DynamicArray();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(1,0);
        dynamicArray.add(1,3);

        dynamicArray.foreach((e)->{
            System.out.print(e+" ");
        });

        System.out.println();

        for(int x:dynamicArray){
            System.out.print(x+" ");
        }

        System.out.println();

        dynamicArray.stream().forEach((e)->{
            System.out.print(e+" ");
        });






    }
}
