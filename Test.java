import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class Test extends WindowAdapter implements ActionListener
{
	static ResultSet rs;
	TextField txt1;
	TextField txt2;
	TextField txt3;
	Frame f;
	Button next,first,previous,last;
	Test()
	{
		f=new Frame("Dept");
		f.setVisible(true);
		f.setSize(250,160);
		f.setLayout(new FlowLayout());
		f.setBackground(Color.BLUE);
		Label dno=new Label("DEPTNO");
		txt1=new TextField(20);
		Label dname=new Label("DNAME");
		txt2=new TextField(20);
		Label loc=new Label("LOC");
		txt3=new TextField(20);
		Button first=new Button("first");
		Button next=new Button("next");
		Button last=new Button("last");
		Button previous=new Button("previous");
		f.add(dno);
		f.add(txt1);
		f.add(dname);
		f.add(txt2);
		f.add(loc);
		f.add(txt3);
		f.add(first);
		f.add(next);
		f.add(last);
		f.add(previous);
		first.addActionListener(this);
		next.addActionListener(this);
		last.addActionListener(this);
		previous.addActionListener(this);
		f.addWindowListener(this);
		try
		{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs=st.executeQuery("select * from dept");
		}//try
		catch (Exception e)
		{
		}//catch
	}//constructor
	public static void main(String ar[])
	{
		Test t=new Test();	
	}//main
	public void actionPerformed(ActionEvent ae)
	{
		String caption=ae.getActionCommand();
		try
		{
		if(caption.equals("first"))
		{
			rs.first();
			txt1.setText(rs.getString(1));
			txt2.setText(rs.getString(2));
			txt3.setText(rs.getString(3));
		}//if for first
		if(caption.equals("next"))
		{
			rs.next();
			txt1.setText(rs.getString(1));
			txt2.setText(rs.getString(2));
			txt3.setText(rs.getString(3));
		}//if for next
		if(caption.equals("last"))
		{
			rs.last();
			txt1.setText(rs.getString(1));
			txt2.setText(rs.getString(2));
			txt3.setText(rs.getString(3));
		}//if for last
		if(caption.equals("previous"))
		{
			rs.previous();
			txt1.setText(rs.getString(1));
			txt2.setText(rs.getString(2));
			txt3.setText(rs.getString(3));
		}//if for previous
		}//try
		catch(Exception se)
		{
		}//catch
		}//actionPerformed
    public void windowClosing(WindowEvent we)
	{
		System.exit(1);
	}//windowClosing
	public void windowClosed(WindowEvent we)
	{
		System.exit(1);
	}//windowCLosed
}//class