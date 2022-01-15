public class New_Order {

    public String New_Order(String name,int Cno,int num,double total){
        String sql="insert into order_management_system (Customer,CommodityNo,Commoditynum,TotalPrice,Createtime)" +
                "values (+'"+name+"',"+Cno+","+num+","+total+",now())";
        return sql;
    }
    public String Price(int Cno){
        String sql="select ComPrice from Commodity where CommodityNo="+Cno+";";
        return sql;
    }

    public String num(int Cno){
        String sql="select ComNum from Commodity where CommodityNo="+Cno+";";
        return sql;
    }

    public String update(int Cno,int beforenum,int num){
        String sql="update Commodity set ComNum="+(beforenum-num)+" where CommodityNo="+Cno+";";
        return sql;
    }
}



/* create table order_management_system (
    -> OrderNO int primary key auto_increment,
    -> Customer varchar(255),
    -> CommodityNo int,
    -> Commoditynum int,
    -> TotalPrice double,
    -> Createtime datetime);*/