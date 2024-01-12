<template >
    <div class="row">
        <div class="col-6">
            <h3>{{ titulo }} Instituição</h3>
        </div>
        <div class="col">
          <MensagemAlerta :msg="msg" v-show="msg" />
        </div>
    </div>
    <hr>
    <form id="formInstituicao" @submit.prevent="botaoGrava">
        <div class="mb-3">
            <label for="nome" class="form-label">Nome Instituição</label>
            <input type="text" class="form-control" id="nome" v-model="this.$parent.nome">
        </div>
        <div class="row">
            <div class="col mb-3">
                <label for="tipo" class="form-label">CNPJ</label>
                <input type="text" class="form-control" id="cnpj" v-model="this.$parent.cnpj">
            </div>
            <div class="col mb-3">
                <label for="tipo" class="form-label">Tipo</label>
                <input type="text" class="form-control" id="tipo" v-model="this.$parent.tipo">
            </div>
            <div class="col mb-3">
                <label for="segmento" class="form-label">Segmento</label>
                <input type="text" class="form-control" id="segmento" v-model="this.$parent.segmento">
            </div>
        </div>
        <div class="row">
            <button type="submit" class="btn btn-primary col" id="acoes">{{ tituloBotao }}</button>
            <button type="button" class="btn btn-danger col" @click="botaoCancela">Cancela</button>
        </div>
    </form>
</template>

<script>
import MensagemAlerta from "../components/MensagemAlerta.vue";

export default {
    name: 'FormularioInstituicao',
    components: {
        MensagemAlerta,
    },
    props: {
        botaoGrava: Function,
        botaoCancela: Function,
        titulo: String,
        tituloBotao: String,
        msg: String,
    },
    data() {
        return {
            id: null,
            nome: null,
            cnpj: null,
            tipo: null,
            segmento: null,
            instituicoes: [],
        }
    },
}
</script>

<style scoped>
#acoes {
    margin-right: 10px;
}
</style>