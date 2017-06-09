import javax.swing.*;

public class LESCalculos {
    private AtributosEstatistico[] vetor;
    private CalculosEstatisticaPrincipal tabela;

    public void alterarDadoslTabela(AtributosEstatistico calculos) {
        float min = calculos.getMinimo().floatValue();
        float max = calculos.getMaximo().floatValue();
        float indice = calculos.getIntervalo().floatValue();
        int tam = calculos.getTamanho().intValue();
        setVetor(new AtributosEstatistico[calculos.getTamanho().intValue()]);
        for (int i = 0; i < calculos.getTamanho().intValue(); i++) {
            calculos = new AtributosEstatistico();
            calculos.setMinimo(Float.valueOf(min));
            calculos.setIntervalo(Float.valueOf(indice));
            calculos.setTamanho(Integer.valueOf(tam));
            min += calculos.getIntervalo().floatValue();
            if (i == calculos.getTamanho().intValue() - 1) calculos.setMaximo(Float.valueOf(max));
            else {
                calculos.setMaximo(Float.valueOf(min));
            }
            getVetor()[i] = calculos;
        }
    }

    public void calcularMedia(AtributosEstatistico calculos, LESCalculos LES_vetor, JTable tabela) {
        float min = LES_vetor.getVetor()[0].getMinimo().floatValue();
        float max = LES_vetor.getVetor()[(calculos.getTamanho().intValue() - 1)].getMaximo().floatValue();
        float indice = calculos.getIntervalo().floatValue();
        float media_aritmetica_total = 0.0F;
        int tam = calculos.getTamanho().intValue();
        int fac = LES_vetor.getVetor()[0].getFi().intValue();
        for (int i = 0; i < calculos.getTamanho().intValue(); i++) {
            calculos = new AtributosEstatistico();
            calculos.setTamanho(Integer.valueOf(tam));
            calculos.setMinimo(Float.valueOf(min));
            calculos.setIntervalo(Float.valueOf(indice));
            min += calculos.getIntervalo().floatValue();
            if (i == calculos.getTamanho().intValue() - 1) calculos.setMaximo(Float.valueOf(max));
            else {
                calculos.setMaximo(Float.valueOf(min));
            }
            calculos.setFi(Integer.valueOf(Integer.parseInt(tabela.getValueAt(i, 2).toString())));
            if (i == 0) {
                calculos.setFac(LES_vetor.getVetor()[0].getFi());
            } else {
                fac += LES_vetor.getVetor()[i].getFi().intValue();
                calculos.setFac(Integer.valueOf(fac));
            }
            calculos.setPonto_medio(Float.valueOf((calculos.getMaximo().floatValue() + calculos.getMinimo().floatValue()) / 2.0F));
            calculos.setMedia_aritmetica(Float.valueOf(calculos.getPonto_medio().floatValue() * calculos.getFi().intValue()));
            media_aritmetica_total += calculos.getMedia_aritmetica().floatValue();
            if (i == calculos.getTamanho().intValue() - 1) {
                calculos.setSoma_fi(calculos.getFac());
                calculos.setMedia_aritmetica_total(Float.valueOf(media_aritmetica_total / calculos.getSoma_fi().intValue()));
            }
            getVetor()[i] = calculos;
        }
    }

    public void calcularEstatistica(AtributosEstatistico calculos, LESCalculos LES_vetor, JTable tabela) {
        float media_aritmetica_total = LES_vetor.getVetor()[(calculos.getTamanho().intValue() - 1)].getMedia_aritmetica_total().floatValue();
        float variancia = 0.0F;
        float desvio_absoluto = 0.0F;
        float min = LES_vetor.getVetor()[0].getMinimo().floatValue();
        float max = LES_vetor.getVetor()[(calculos.getTamanho().intValue() - 1)].getMaximo().floatValue();
        float indice = calculos.getIntervalo().floatValue();
        int tam = calculos.getTamanho().intValue();
        int fac = LES_vetor.getVetor()[0].getFi().intValue();
        for (int i = 0; i < calculos.getTamanho().intValue(); i++) {
            calculos = new AtributosEstatistico();
            calculos.setTamanho(Integer.valueOf(tam));
            calculos.setMinimo(Float.valueOf(min));
            calculos.setIntervalo(Float.valueOf(indice));
            min += calculos.getIntervalo().floatValue();
            if (i == calculos.getTamanho().intValue() - 1) calculos.setMaximo(Float.valueOf(max));
            else {
                calculos.setMaximo(Float.valueOf(min));
            }
            calculos.setFi(Integer.valueOf(Integer.parseInt(tabela.getValueAt(i, 2).toString())));
            if (i == 0) {
                calculos.setFac(LES_vetor.getVetor()[0].getFi());
            } else {
                fac += LES_vetor.getVetor()[i].getFi().intValue();
                calculos.setFac(Integer.valueOf(fac));
            }
            calculos.setPonto_medio(Float.valueOf((calculos.getMaximo().floatValue() + calculos.getMinimo().floatValue()) / 2.0F));
            calculos.setMedia_aritmetica(Float.valueOf(calculos.getPonto_medio().floatValue() * calculos.getFi().intValue()));
            float DAM = calculos.getPonto_medio().floatValue() - media_aritmetica_total;
            if (DAM < 0.0F) calculos.setDesvio_absoluto_parte(Float.valueOf(DAM * -1.0F));
            else {
                calculos.setDesvio_absoluto_parte(Float.valueOf(DAM));
            }
            calculos.setDesvio_absoluto(Float.valueOf(calculos.getDesvio_absoluto_parte().floatValue() * calculos.getFi().intValue()));
            calculos.setVariancia_parte(Float.valueOf(calculos.getDesvio_absoluto_parte().floatValue() * calculos.getDesvio_absoluto_parte().floatValue()));
            calculos.setVariancia(Float.valueOf(calculos.getVariancia_parte().floatValue() * calculos.getFi().intValue()));
            variancia += calculos.getVariancia().floatValue();
            desvio_absoluto += calculos.getDesvio_absoluto().floatValue();
            if (i == calculos.getTamanho().intValue() - 1) {
                calculos.setMedia_classe(Float.valueOf((getVetor()[0].getMinimo().floatValue() + calculos.getMaximo().floatValue()) / 2.0F));
                calculos.setSoma_fi(calculos.getFac());
                calculos.setMedia_aritmetica_total(Float.valueOf(media_aritmetica_total));
                calculos.setVariancia_total(Float.valueOf(variancia / (calculos.getSoma_fi().intValue() - 1)));
                calculos.setDesvio_absoluto_total(Float.valueOf(desvio_absoluto / calculos.getSoma_fi().intValue()));
                double dp = Math.sqrt(calculos.getVariancia_total().floatValue());
                calculos.setDesvio_padrao_total(Double.valueOf(dp));
                calculos.setCoeficiente_variacao_total(Double.valueOf(calculos.getDesvio_padrao_total().doubleValue() / calculos.getMedia_aritmetica_total().floatValue() * 100.0D));
            }
            getVetor()[i] = calculos;
        }
    }

    public AtributosEstatistico[] getVetor() {
        return this.vetor;
    }

    public void setVetor(AtributosEstatistico[] vetor) {
        this.vetor = vetor;
    }

    public CalculosEstatisticaPrincipal getTabela() {
        return this.tabela;
    }

    public void setTabela(CalculosEstatisticaPrincipal tabela) {
        this.tabela = tabela;
    }
}