import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogoNovaReceita extends JInternalFrame
{
  private JLabel labelNome, labelCalorias;
  private JTextField textFieldNome, textFieldCalorias;
  private JButton botaoOk;
  private JScrollPane listaReceitasScroll;
  private JList listaReceitas;
  private JPanel panel;
  private ControleNovaReceita controle;
  private ControleReceitas controleReceitas;

  public DialogoNovaReceita(ControleReceitas controleReceitas)
  {
    super("Estoque", true, true, true, true );

    this.controleReceitas = controleReceitas;
    controle = new ControleNovaReceita(controleReceitas);

    panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);

    labelNome = new JLabel("Nome");
    textFieldNome = new JTextField("Nome da Receita");
    labelCalorias = new JLabel("Calorias");
    textFieldCalorias = new JTextField("1");
    botaoOk = new JButton("OK");

    listaReceitas = new JList(controle.getItensReceita());
    listaReceitas.setLayoutOrientation(JList.VERTICAL);

    listaReceitasScroll = new JScrollPane(listaReceitas);

    panel.setLayout(new FlowLayout());
    panel.add(listaReceitasScroll);
    panel.add(labelNome);
    panel.add(textFieldNome);
    panel.add(labelCalorias);
    panel.add(textFieldCalorias);
    panel.add(botaoOk);
    setSize(450, 300);
    setVisible(true);

    botaoOk.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        int calorias = Integer.parseInt(textFieldCalorias.getText());
        String nomeReceita = textFieldNome.getText();
        ArrayList<Ingrediente> ingredientes = listaReceitas.getSelectedValuesList();

        controle.criarReceita(nomeReceita, calorias, ingredientes);
        controle.salvarReceita();
      }
    });
  }
}
