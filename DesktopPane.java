import javax.swing.JDesktopPane;

public class DesktopPane extends javax.swing.JDesktopPane
{
  private ImageIcon icon = new ImageIcon("backgroundImage.jpg");
  private Image image = icon.getImage();
  private Image newimage = image.getScaledInstance(1024, 768, Image.SCALE_SMOOTH);

  public DesktopPane()
  {
  }

  @Override
  protected void paintComponent(Graphics g)
  {
      super.paintComponent(g);
      g.drawImage(newimage, 0, 0, this);
  }
}
