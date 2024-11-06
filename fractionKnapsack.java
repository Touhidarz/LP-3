import java.util.*;

class Item{
    double value;
    double weight;

    Item(double value, double weight){
        this.value = value;
        this.weight = weight;
    }
}

public class fractionKnapsack {
    public static double result(Item[] item, double capacity){
        double[] ratio = new double[item.length];
        double result = 0.0;

        for(int i=0; i<item.length; i++){
            ratio[i] = item[i].value/item[i].weight;
        }

        Arrays.sort( item, (a,b)-> Double.compare(b.value/b.weight, a.value/a.weight));
        for(int i=0; i<item.length; i++){
            if(capacity <= 0){
                break;
            }

            if(item[i].weight <= capacity){
                result += item[i].value;
                capacity -= item[i].weight;
            }
            else{
                result += item[i].value*(capacity/item[i].weight);
            }
        }
        return result;
    }
    public static void main(String args[]){
        double capacity = 15;
        Item[] item = {
            new Item(10, 2),   // Value = 60, Weight = 10
            new Item(5, 3),  // Value = 100, Weight = 20
            new Item(15, 5),   // Value = 120, Weight = 30
            new Item(7, 7),   // Value = 120, Weight = 30
            new Item(6, 1),   // Value = 120, Weight = 30
            new Item(18, 4),   // Value = 120, Weight = 30
            new Item(3, 1)
        };
        System.out.print("Result : "+ result(item, capacity));
    }
}
