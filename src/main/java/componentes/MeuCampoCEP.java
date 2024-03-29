package Componentes;

import componentes.MeuCampoFormatado;
import componentes.MeuComponente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 * @author Jorge
 */
public class MeuCampoCEP extends MeuCampoFormatado implements MeuComponente {

    public MeuCampoCEP(int colunas, boolean obrigatorio, String dica, boolean podeHabilitar) {
        super(colunas, obrigatorio, dica, podeHabilitar);
        try {
            MaskFormatter mascara = new MaskFormatter("#####-###");
            mascara.setPlaceholderCharacter('_');
            mascara.install(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar o CEP");
            e.printStackTrace();
        }
    }

    @Override
    public Object getValor() {
        return getText();
    }

    @Override
    public void setValor(Object valor) {
        setText((String) valor);
    }

    @Override
    public void limpar() {
        setText("");
    }

    @Override
    public boolean eValido() {
        return true;
    }

    @Override
    public boolean eObrigatorio() {
        return obrigatorio;
    }

    @Override
    public boolean eVazio() {
        return getText().trim().isEmpty();
    }
}
