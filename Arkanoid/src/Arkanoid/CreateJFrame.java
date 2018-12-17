
package Arkanoid;

import javax.swing.JFrame;

public class CreateJFrame extends JFrame {
  
    
    public JFrame create(Renderer renderer){
        JFrame jframe = new JFrame();
        jframe.setFocusable(true);
        jframe.add(renderer);
        jframe.setResizable(false);
        jframe.setBounds(0, 0, 566, 600);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setTitle("Arkanoid");
        return jframe;
    }
}
