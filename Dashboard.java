import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends Frame {
   TextField Name1, College, RegNo, IdNo, Campus, Depart;
   Label name1, college, idno, campus, depart, regno;
   Button b1, b2, b3;

  public Dashboard(String studentName,  String regNo) {
      setSize(300, 600);
      setLayout(null);
      setVisible(true);

      name1 = new Label("Student Names:");
      add(name1);

      idno = new Label("National Identity:");
      add(idno);

      this.college = new Label("College");
      add(this.college);

      campus = new Label("Campus:");
      add(campus);

      depart = new Label("Department:");
      add(depart);

      regno = new Label("RegNo");
      add(regno);

      Name1 = new TextField(studentName);
      add(Name1);

      College = new TextField();
      add(College);

      IdNo = new TextField();
      add(IdNo);

      RegNo = new TextField(regNo);
      add(RegNo);

      Campus = new TextField();
      add(Campus);

      Depart = new TextField();
      add(Depart);

      name1.setBounds(5, 25, 90, 30);
      this.college.setBounds(5, 55, 80, 30);
      idno.setBounds(5, 85, 100, 30);
      regno.setBounds(5, 115, 80, 30);
      campus.setBounds(5, 145, 80, 30);
      depart.setBounds(5, 175, 80, 30);

      Name1.setBounds(120, 25, 89, 30);
      College.setBounds(120, 55, 80, 30);
      IdNo.setBounds(120, 85, 100, 30);
      RegNo.setBounds(120, 115, 80, 30);
      Campus.setBounds(120, 145, 80, 30);
      Depart.setBounds(120, 175, 80, 30);

      b1 = new Button("logout");
      add(b1);
      b1.setBounds(250, 25, 40, 30);

      // ActionListener for logout button
      b1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // Implement logout functionality here
            dispose(); // Close the Dashboard window on logout

         }
      });
   }


}
