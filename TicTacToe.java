import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class TicTacToe {

    JFrame myFrame = new JFrame();

    JButton[][] grid;
    int count = 0; // will be used to determine player

    public TicTacToe(int width, int length) {
      myFrame.setLayout(new GridLayout(width, length));
      grid = new JButton[width][length];
      for (int r = 0; r < length; r++) {
        for (int c = 0; c < width; c++) {
          grid[r][c] = new JButton(); // creates a button for each element in the 2d array
          grid[r][c].setText(""); // sets the button to empty text
          grid[r][c].addActionListener(new buttonClicker()); // button will be clickable
          myFrame.add(grid[r][c]); // display grid of buttons

        }
      }


  myFrame.setSize(500,500);
  myFrame.setTitle("TicTacToe");
  myFrame.setLocationRelativeTo(null);  // center the game
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	myFrame.setVisible(true);
}


private class buttonClicker implements ActionListener {

  public void actionPerformed(ActionEvent e) {
    JButton clicked = (JButton)e.getSource();
    if (count % 2 == 0) { // first click will be X,
      clicked.setText("X"); // change empty text to X
    }

    else {
      clicked.setText("O"); // every other click will be O
    }

    count++;  // iterate the number of clicks to change player


      if (grid[0][0].getText().equals(grid[1][1].getText()) && grid[0][0].getText().equals(grid[2][2].getText()) && !grid[0][0].getText().equals("")) { // win from diagonal bottom  to top
        JOptionPane.showMessageDialog(null, grid[0][0].getText() + " won!");
      }

      else if (grid[0][2].getText().equals(grid[1][1].getText()) && grid[0][2].getText().equals(grid[2][0].getText()) && !grid[2][0].getText().equals("")) { // win from diagonal top to bottom
        JOptionPane.showMessageDialog(null, grid[0][2].getText() + " won!");
      }



      else if (grid[0][0].getText().equals(grid[1][0].getText()) && grid[0][0].getText().equals(grid[2][0].getText()) && !grid[1][0].getText().equals("")) { // win from top row
        JOptionPane.showMessageDialog(null, grid[0][0].getText() + " won!");
      }

      else if (grid[0][1].getText().equals(grid[1][1].getText()) && grid[0][1].getText().equals(grid[2][1].getText()) && !grid[0][1].getText().equals("")) { // win from middle row
        JOptionPane.showMessageDialog(null, grid[0][1].getText() + " won!");
      }

      else if (grid[0][2].getText().equals(grid[1][2].getText()) && grid[0][2].getText().equals(grid[2][2].getText()) && !grid[1][2].getText().equals("")) { // win from bottom row
        JOptionPane.showMessageDialog(null, grid[0][2].getText() + " won!");
      }




      else if (grid[0][0].getText().equals(grid[0][1].getText()) && grid[0][0].getText().equals(grid[0][2].getText()) && !grid[0][0].getText().equals("")) { // win from first column
        JOptionPane.showMessageDialog(null, grid[0][0].getText() + " won!");
      }

      else if (grid[1][0].getText().equals(grid[1][1].getText()) && grid[1][0].getText().equals(grid[1][2].getText()) && !grid[1][0].getText().equals("")) { // win from second column
        JOptionPane.showMessageDialog(null, grid[0][2].getText() + " won!");
      }

      else if (grid[2][0].getText().equals(grid[2][1].getText()) && grid[0][2].getText().equals(grid[2][2].getText()) && !grid[0][2].getText().equals("")) { // win from third row
        JOptionPane.showMessageDialog(null, grid[2][0].getText() + " won!");
      }

      if  (count > 8) {   // grid is full and nobody has won
        JOptionPane.showMessageDialog(null, "It's a tie!");
      }

  }

  }


public static void main(String [] args) {
  new TicTacToe(3,3);
}


}
