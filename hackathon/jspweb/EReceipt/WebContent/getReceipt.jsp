<%@ page contentType="text/html;charset=utf-8" session="false"
			import="java.sql.*,org.json.simple.*"%>
			
<%

request.setCharacterEncoding("utf-8");

String receipt_id = request.getParameter("receipt_id");
//String receipt_id = "3003";

int numOfData = 0;

int item_id = 0;
int amount = 0;

int product_id = 0;
String product_name = null;
int product_price = 0;
String product_category = null;

try {
	
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	
	Class.forName("com.mysql.jdbc.Driver");  
	String DB_URL ="jdbc:mysql://localhost/jaj7884";

	Connection con =  DriverManager.getConnection(DB_URL, "jaj7884", "wkddj1960!");
	
	String sql = "SELECT COUNT(receipt_id) FROM item WHERE receipt_id=?";
	
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, Integer.parseInt(receipt_id)); 
	ResultSet result = ps.executeQuery();
	if(result.next()) {
		numOfData = result.getInt(1);
	}
	result.close();
	ps.close();
	
	
	sql = "SELECT *FROM item WHERE receipt_id=?";
	
	pstmt = con.prepareStatement(sql);
	
	pstmt.setInt(1, Integer.parseInt(receipt_id));

	rs = pstmt.executeQuery();
	
	int[] iid = new int[numOfData];
	int[] amt = new int[numOfData];
	int[] pid = new int[numOfData];
	String[] pname = new String[numOfData];
	int[] pprice = new int[numOfData];
	String[] pcategory = new String[numOfData];

	
	int count = 0;
	while(rs.next()) {
	item_id = rs.getInt("item_id");
	iid[count] = rs.getInt("item_id");
	count++;
	}
	
	sql = "SELECT *FROM item WHERE item_id=?";
	
	for(int i=0;i<numOfData;i++) {
		
		
		pstmt2 = con.prepareStatement(sql);
		pstmt2.setInt(1, iid[i]);
		rs2 = pstmt2.executeQuery();
		
		if(rs2.next()){
		
		amt[i] = rs2.getInt("amount");
		pid[i] = rs2.getInt("product_id");
		
		}
		
		pstmt2.clearParameters();
		
	}
	
	sql = "SELECT *FROM product WHERE product_id=?";
		
	for(int i=0;i<numOfData;i++) {
		
		pstmt3 = con.prepareStatement(sql);
		pstmt3.setInt(1, pid[i]);
		rs3 = pstmt3.executeQuery();
		
		if(rs3.next()) {
		
		pname[i] = rs3.getString("product_name");
		pprice[i] = rs3.getInt("product_price");
		pcategory[i] = rs3.getString("product_category");
		
		}
		pstmt3.clearParameters();
		
	}
	
	
%>

<%
JSONObject jsonMain = new JSONObject();
JSONArray jArray = new JSONArray();

JSONObject jObject = new JSONObject();

for(int i=0;i<numOfData;i++) {

jObject.put("product_name",pname[i]);
jObject.put("product_price",pprice[i]);
jObject.put("product_category",pcategory[i]);
jObject.put("product_amount",amt[i]);

jArray.add(0,jObject);

jsonMain.put("List",jArray.get(i));

out.println(jsonMain.toJSONString());

}


	rs.close();
	pstmt.close();
	rs2.close();
	pstmt2.close();
	rs3.close();
	pstmt3.close();		
	con.close();
	
	
}catch(SQLException e) {
	out.print(e);
	return;
}


%>
