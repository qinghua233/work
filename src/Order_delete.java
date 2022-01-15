public class Order_delete {
    public String order_delete(int OrderNo){
        String sql="delete from order_management_system where OrderNO="+OrderNo+";";
        return sql;
    }

    public String Cno(int OrderNo){
        String sql="select CommodityNo from order_management_system where OrderNo="+OrderNo+";";
        return sql;
    }

    public String num(int num){
        String sql="select Commoditynum from order_management_system where OrderNo="+num+";";
        return sql;
    }

    public String beforenum(int Cno){
        String sql="select ComNum from Commodity where CommodityNo="+Cno+";";
        return sql;
    }

    public String update(int Cno,int num,int beforenum){
        String sql="update Commodity set ComNum="+(beforenum+num)+" where CommodityNo="+Cno+"";
        return sql;
    }
}
