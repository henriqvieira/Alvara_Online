package controller;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Analista;
import model.Requerente;
import model.Usuario;


@ManagedBean
@SessionScoped
 public class UsuarioBean implements Serializable{
    private Usuario usuarioLogado = new Usuario();
    private Requerente requerente = new Requerente();
    private Analista analista = new Analista();
    private Usuario usuario = new Usuario();
    private List<Usuario> list;
    private boolean editando;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    
    public List<Usuario> getList() {
        this.list = usuario.list();
        return list;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public String salvar() {
        if (!isEditando()) {
            list.add(new Usuario(usuario.getNome(), usuario.getCpf(), usuario.getSenha()));
        }
        this.usuario = new Usuario();
        setEditando(false);
        return "listarUsuarios";
    }

    public String excluir(Usuario user) {
        list.remove(user);
        usuario.delete();
        setEditando(false);
        return "listarUsuarios";
    }

    public String editar(Usuario user) {
        this.usuario = user;
        setEditando(true);
        return "editarUsuario";
    }
    
    public String atualizar(Usuario usuario) {
        System.out.println("Entrou no atualizar!!");
        usuario.update();
        //requisicao.list();
        return "listarUsuarios";
    }

    public void limpar() {
        this.usuario = new Usuario();
        setEditando(false);
    }
    
    public String voltar() {
        return "listarUsuarios";
    }

    public String validar() {
        //usar aqui o validar conectando com o banco de dados
        if ("admin".equals(usuario.getCpf()) && "admin".equals(usuario.getSenha())) {
            this.usuarioLogado = usuario;    
            usuario = new Usuario();
            return "login";
        } else {
            return "invalido";
        }
    }
    
    public String cadastrar(){
        System.out.println("Entrou no cadastrar usuário!!");
        usuario.insert();
        //usuario.listar();
        return "listar";
    }
    
}
