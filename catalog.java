import java.util.ArrayList;
public class catalog
{

public Items allitems=new Items();

    public ArrayList<Item>viewAllitems() {
        return allitems.getItemList();
    }

    public ArrayList<Item>searchbybrandname(String name){
        ArrayList<Item>branditems=new ArrayList<Item>();
        for(int i=0;i<allitems.getItemList().size();i++){
            if(allitems.getItemList().get(i).getBrand().equals(name)){
                branditems.add(allitems.getItemList().get(i));
            }
        }
        return branditems;
    }
    public ArrayList<Item>searchbyitemname(String name)
    {
        ArrayList<Item>branditems=new ArrayList<Item>();
        for(int i=0;i<allitems.getItemList().size();i++)
        {
            if(allitems.getItemList().get(i).getName().equals(name))
            {
                branditems.add(allitems.getItemList().get(i));
            }
        }
        return branditems;
    }




}
