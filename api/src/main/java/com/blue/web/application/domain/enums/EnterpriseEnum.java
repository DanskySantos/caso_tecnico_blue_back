package com.blue.web.application.domain.enums;

public enum EnterpriseEnum {
    LE_JARDIM ("Le Jardin", "https://www.imoveisluxuososemsaopaulo.com.br/uploads/imovel/galeria/thumb-8fce3f9f871564f78e2ad61313fbb389.jpeg"),
    EVIAN ("Evian", "https://midias.jornalcruzeiro.com.br/wp-content/uploads/2019/11/Sorocaba-ter%C3%A1-um-dos-pr%C3%A9dios-mais-altos.jpg"),
    OLIMPIA_THERMAS ("Olímpia Thermas", "https://img.kenlo.io/VWRCUkQ2Tnp3d1BJRDBJVe1szkhnWr9UfpZS9ftWwjXgr7v5Znen3XVcMHllDVRJJeIbi3YwVYEtu2Z17cpj7wcJg5EkQbSlnhjY5KrOu4yXjmeJyLzYkOPKi8-STcjd5q0Q4aj3V0yhvvM8Z%2BEVaW1cZMJxSw7jQamkJCFBuxO9unfTTKVqHGBX5goWnStiwniBfrv811MexyisBMnGtHe0QLH8B15NOLMNAdsz6EIJ9xa9SUxy8h8d55m-oS7TO7S-K5%2BhxzlXFx5k9oa%2BSqu619jCLJU4Vr0lNm4L5VMZWe0S2-TJT-8%2B5wEDqv3JFhXchgzWgPAoc9j0QdxKnaAcll6VH%2BFGvBrqwNHE1vOob0uGOlM087iWqqCzNKr7Sv-seGerj9QO-5PZPcMWLIepG2NMQTMlcH9WuUDXtevAoQz5bD3YuBAVFULf1o4moXZrYEdR-9tf52I%3D.jpg");

    private final String nome;
    private final String imagem;

    EnterpriseEnum(String nome, String imagem) {
        this.nome = nome;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }
}
