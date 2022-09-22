import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
  
public class Layout extends Aluno implements ActionListener{
  
    JFrame jf = new JFrame();

    JLabel Nome, Idade, Endereco;
        
    JTextField tnome, tidade, tendereco;

    JButton buttonOk, buttonLimpar, buttonMostrar, buttonSair;

    ArrayList<Aluno> alunos = new ArrayList<>();

    Layout() {
    
        JPanel p1 = new JPanel();
    
        p1.setLayout(new GridLayout(3, 2, 10, 10));
        
        JPanel p2 = new JPanel();
    
        p2.setLayout(new GridLayout(1, 4, 10, 10));
    
        Nome = new JLabel("Nome");
    
        tnome = new JTextField(20);
    
        Idade = new JLabel("Idade");
    
        tidade = new JTextField(20);

        Endereco = new JLabel("Endereco");
    
        tendereco= new JTextField(20);
        
        buttonOk = new JButton("Ok");
    
        buttonLimpar = new JButton("Limpar");

        buttonMostrar = new JButton("Mostrar");

        buttonSair = new JButton("Sair");

        buttonOk.addActionListener(this);
        buttonLimpar.addActionListener(this);
        buttonMostrar.addActionListener(this);
        buttonSair.addActionListener(this);

        p1.add(Nome);
    
        p1.add(tnome);
    
        p1.add(Idade);
    
        p1.add(tidade);
    
        p1.add(Endereco);

        p1.add(tendereco);
    
        p2.add(buttonOk);
    
        p2.add(buttonLimpar);

        p2.add(buttonMostrar);

        p2.add(buttonSair);
    
        jf.add(p1, "North");
    
        jf.add(p2, "South");

        jf.setVisible(true);
    
        jf.setSize(400, 180);
        jf.setTitle("TP02 - LP2l4");
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==buttonOk)
        {
            Aluno aluno = new Aluno();

            aluno.setNome(tnome.getText());
            aluno.setIdade(Integer.parseInt(tidade.getText()));
            aluno.setEndereco(tendereco.getText());
            UUID uuid = UUID.randomUUID();
            aluno.setUUID(uuid);

            alunos.add(aluno);

            return;
        }
        else
        if (e.getSource()==buttonLimpar)
        {
            tnome.setText("");
            tidade.setText("");
            tendereco.setText("");
            return;
        }
        else
        if (e.getSource()==buttonMostrar)
        {
            JOptionPane teste = new JOptionPane();

            String mensagem = "";

            for(Aluno aluno: alunos){
                mensagem += "ID: " + aluno.getUUID() + " Nome: " + aluno.getNome() + "\n";
            }

            teste.showMessageDialog(jf, mensagem);
            return;
        } else 
        if (e.getSource()==buttonSair)
        {
            System.exit(0);
        }
    }

    public static void main(String args[])
    {
        new Layout();
    }
}