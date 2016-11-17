import java.awt.*;
import javax.swing.*;

public class DesktopPane extends JDesktopPane
{
  private ImageIcon icon = new ImageIcon("backgroundImage.jpg");
  private Image image = icon.getImage();
  private Image newImage = image.getScaledInstance(1024, 768, Image.SCALE_SMOOTH);

  public DesktopPane()
  {
  }

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(newImage, 0, 0, this);
  }
}
