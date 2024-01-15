<template>
  <div class="main-container">
    <div>
      <h1>Cadastro de instituições</h1>
    </div>
    <div>
      <button type="button" class="btn btn-primary" @click="toggleDivCadastro">Nova Instituição</button>
    </div>

    <div v-show="mostrarDivCadastro">
      <div class="overlay" @click="fecharDivCadastro"></div>
      <div class="row divCadastro">
        <FormularioInstituicao titulo="Nova" tituloBotao="Grava" :botaoGrava="gravaInstituicao"
          :botaoCancela="cancelaCadastro" :msg="msg" />
      </div>
    </div>

    <div v-show="mostrarDivAlteraCadastro">
      <div class="overlay" @click="fecharDivCadastro"></div>
      <div class="row divCadastro">
        <FormularioInstituicao titulo="Edita" tituloBotao="Altera" :botaoGrava="atualizaInstituicao"
          :botaoCancela="cancelaCadastro" :msg="msg" />
      </div>
    </div>

    <div v-show="mostrarDivExcluiCadastro">
      <div class="overlay" @click="fecharDivCadastro"></div>
      <div class="row divCadastro">
        <FormularioInstituicao titulo="Exclui" tituloBotao="Exclui" :botaoGrava="excluiInstituicao"
          :botaoCancela="cancelaCadastro" :msg="msg" />
      </div>
    </div>

    <table class="table table-hover">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Nome instituições</th>
          <th scope="col">CNPJ</th>
          <th scope="col">Tipo</th>
          <th scope="col">Segmento</th>
          <th scope="col">Ações</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="instituicao in instituicoes" :key="instituicao.id">
          <td>{{ instituicao.id }}</td>
          <td>{{ instituicao.nome }}</td>
          <td>{{ instituicao.cnpj }}</td>
          <td>{{ instituicao.tipo }} </td>
          <td>{{ instituicao.segmento }} </td>
          <td>
            <button type="button" id="acoes" class="btn btn-primary" @click="editaCadastro(instituicao)">Editar</button>
            <button type="button" class="btn btn-danger" @click="excluiCadastro(instituicao)">Excluir</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import FormularioInstituicao from '../components/FormularioInstituicao.vue';

export default {
  name: 'InstitucoesView',
  components: {
    FormularioInstituicao,
  },
  data() {
    return {
      id: null,
      nome: null,
      cnpj: null,
      tipo: null,
      segmento: null,
      instituicoes: [],
      mostrarDivCadastro: false,
      mostrarDivAlteraCadastro: false,
      mostrarDivExcluiCadastro: false,
      msg: null,
    }
  },
  methods: {
    async buscaInstituicoes() {
      try {
        const req = await fetch("http://localhost:8180/api/instituicoes", {
          mode: 'cors',
        });
        this.instituicoes = await req.json();
      } catch (error) {
        console.error("Erro ao buscar instituições:", error);
      }
    },
    toggleDivCadastro() {
      this.mostrarDivCadastro = !this.mostrarDivCadastro;
    },
    toggleDivAlteraCadastro() {
      this.mostrarDivAlteraCadastro = !this.mostrarDivAlteraCadastro;
    },
    toggleDivExcluiCadastro() {
      this.mostrarDivExcluiCadastro = !this.mostrarDivExcluiCadastro;
    },
    fecharDivCadastro() {
      this.mostrarDivCadastro = false;
      this.mostrarDivAlteraCadastro = false;
      this.mostrarDivExcluiCadastro = false;
    },
    async gravaInstituicao(e) {
      e.preventDefault();

      const instituicao = {
        nome: this.nome,
        cnpj: this.cnpj,
        tipo: this.tipo,
        segmento: this.segmento
      }

      const dataInstituicao = JSON.stringify(instituicao);

      try {
        const req = await fetch("http://localhost:8180/api/instituicoes", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: dataInstituicao
        });

        const res = await req.json();

        if (Object.keys(res).length === 0 && res.constructor === Object) {
          // Verifica se a resposta está vazia antes de tentar analisar o JSON
          console.log("Resposta vazia");
        } else {
          console.log(res);
          this.msg = "Cadastrada com sucesso";
          setTimeout(() => this.msg = "", 3000);

          this.nome = "",
          this.cnpj = "",
          this.tipo = "",
          this.segmento = ""

          this.buscaInstituicoes();
        }
      } catch (error) {
        console.error("Erro ao processar a resposta:", error);
      }
    },
    cancelaCadastro() {
      this.fecharDivCadastro();
      this.buscaInstituicoes();
    },
    async editaCadastro(instituicao) {
      this.id = instituicao.id;
      this.nome = instituicao.nome;
      this.cnpj = instituicao.cnpj;
      this.tipo = instituicao.tipo;
      this.segmento = instituicao.segmento;
      this.toggleDivAlteraCadastro();
    },
    async atualizaInstituicao(e) {
      e.preventDefault();

      const instituicao = {
        id: this.id,
        nome: this.nome,
        cnpj: this.cnpj,
        tipo: this.tipo,
        segmento: this.segmento
      }

      try {
        const req = await fetch(`http://localhost:8180/api/instituicoes/${instituicao.id}`, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(instituicao)
        });

        const res = await req.json();

        if (Object.keys(res).length === 0 && res.constructor === Object) {
          // Verifica se a resposta está vazia antes de tentar analisar o JSON
          console.log("Resposta vazia");
        } else {
          console.log(res);
          this.msg = `Alterado com sucesso.`;
          setTimeout(() => this.msg = "", 3000);
          setTimeout(() => this.cancelaCadastro(), 3000);          

          this.nome = "",
          this.cnpj = "",
          this.tipo = "",
          this.segmento = ""

          this.buscaInstituicoes();
        }
      } catch (error) {
        console.error("Erro ao processar a resposta:", error);
      }
    },
    async excluiCadastro(instituicao) {
      this.id = instituicao.id;
      this.nome = instituicao.nome;
      this.cnpj = instituicao.cnpj;
      this.tipo = instituicao.tipo;
      this.segmento = instituicao.segmento;
      this.toggleDivExcluiCadastro();
    },
    async excluiInstituicao(e) {
      e.preventDefault();

      const instituicao = {
        id: this.id,
        nome: this.nome,
        cnpj: this.cnpj,
        tipo: this.tipo,
        segmento: this.segmento
      }
      try {
        await fetch(`http://localhost:8180/api/instituicoes/${instituicao.id}`, {
          method: "DELETE"
        });

        this.msg = `Excluido com sucesso.`;
        console.log(this.msg);

        setTimeout(() => this.msg = "", 3000);
        setTimeout(() => this.cancelaCadastro(), 4000);

        this.nome = "",
        this.cnpj = "",
        this.tipo = "",
        this.segmento = ""
        this.buscaInstituicoes();
      } catch (error) {
        console.error("Erro ao processar a resposta:", error);
      }
    },
  },
  mounted() {
    this.buscaInstituicoes();
  }
}
</script>

<style scoped>
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  /* Sombreamento com transparência */
  z-index: 998;
  /* Abaixo da divCadastro, mas acima do conteúdo da página */
}
.divCadastro {
  border: 1px solid black;
  box-shadow: 0 0 20px rgba(0, 0, 0, 1);
  padding: 40px;
  background-color: #fff;
  width: 800px;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 999;
}

#acoes {
    margin-right: 10px;
}
</style>
