package org.BdTurmaATrab;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Telefone telefone = new Telefone();
        telefone.setDDD(042);
        telefone.setNumero(98561387);
        telefone.setTipo("Aparelho movel");
        
        Telefone telefone2 = new Telefone();
        telefone2.setDDD(042);
        telefone2.setNumero(70450517);
        telefone2.setTipo("Telefone fixo");
        
        Endereco endereco = new Endereco("Rua Julio de Castilho", 2700, "Vila Carli", "Guarapuava");
        
        Cliente c1 = new Cliente();
        c1.setNome("Carlos");
        c1.setData_nascimento("04/02/2002");
        c1.setSexo("Masculino");
        c1.setCpf("1945386978234");
        c1.setEndereco(endereco);
        
        List<Telefone> telefones = new ArrayList<Telefone>();
        telefones.add(telefone);
        telefones.add(telefone2);
        
        c1.setTelefones(telefones);
        
        Venda venda = new Venda();
        venda.setCliente(c1);
        venda.setCodigo("JK8769G");
        
        Produto produto = new Produto();
        produto.setCodigo("KMH92SD5T9J1N");
        produto.setDescricao("Cadeira DRX");
        produto.setValor(450.00);
        produto.setVenda(venda);
        
        Produto produto2 = new Produto();
        produto.setCodigo("S856L4HN59B3F");
        produto.setDescricao("Headset Kraken");
        produto.setValor(560.00);
        produto.setVenda(venda);
        
        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(produto);
        produtos.add(produto2);
        
        venda.setProdutos(produtos);
        
        @SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(telefone);
		session.save(telefone2);
		session.save(endereco);
		session.save(c1);
		session.save(produto);
		session.save(produto2);
		session.save(venda);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
    }
}
