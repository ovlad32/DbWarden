<template>
  <div class="dbedit">
    <p class="db-title">New data source server details</p>

    <b-form class="databaseConfig" style="background:lightyellow" @submit.stop.prevent novalidate>
      <b-form-group label="Type:" label-for="typeFormId">
        <b-form-select
          id="type"
          v-model="item.type"
          :options="types"
          value-field="type"
          text-field="name"
          :state="isTypeOk"
        >
          <b-form-invalid-feedback :state="isTypeOk">Select database type</b-form-invalid-feedback>
        </b-form-select>
      </b-form-group>
      <b-form-group label="Alias:">
        <b-input id="alias" v-model="item.alias" required :state="isAliasOk" />
        <b-form-invalid-feedback :state="isAliasOk">Provide a meaningful name for the data source</b-form-invalid-feedback>
      </b-form-group>
      <b-form-group label="URI:">
        <b-input id="uri" v-model="item.uri" required :state="isUriOk" />
        <b-form-invalid-feedback :state="isUriOk">Provide a URI of the data source</b-form-invalid-feedback>
      </b-form-group>
      <b-form-group label="Login:">
        <b-input id="login" v-model="item.login" />
      </b-form-group>
      <b-form-group label="password:">
        <b-input type="password" id="password" v-model="item.password" autocomplete="new-password" />
      </b-form-group>
      <b-button-group>
        <b-button type="summit" variant="primary" @click="save()">Save</b-button>
        <b-button class="ml-1" variant="secondary" @click="checkParams()">Test connection</b-button>
        <b-button class="ml-1" type="reset" variant="secondary">Cancel</b-button>
      </b-button-group>
    </b-form>
  </div>
</template>

<style>
</style>


<script>
//import { mapState, mapActions } from "vuex";
import { mapGetters } from "vuex";
import DbApi from "../api/databases";
import { eventBus } from "../eventBus";
export default {
  props: {
    //  types: { type: Array },
    id: { type: [Number, String] }
  },
  data() {
    return {
      item: {}
    };
  },

  computed: {
    ...mapGetters({
      types: "db-store/types"
    }),
    isTypeOk() {
      return "type" in this.item;
    },
    isAliasOk() {
      return "alias" in this.item && this.item.alias.trim().length > 0;
    },
    isUriOk() {
      return "uri" in this.item && this.item.uri.trim().length > 0;
    }
  },
  methods: {
    //...mapActions([{ initTypes: "db-store/initTypes" }]),
    save() {
      DbApi.save(this.item).then(r => {
        if (r.data.success) {
          if (r.status === 201) {
            this.item.id = r.data.id;
            eventBus.$emit("databaseDetailsCreated", { message: this.item });
          } else {
            eventBus.$emit("databaseDetailsCreated", { message: this.item });
          }
        }
      });
    },
    checkParams() {
      DbApi.checkParams(this.item);
    }
  },
  mounted() {
    this.$store.dispatch("db-store/initTypes", { forcibly: false });
    //this.initTypes();
    //this.state.
    /*DbApi.getTypes().then(r => {
      this.types = r.data.rows;
    });

    if (this.id) {
      DbApi.getAll({ id: this.id }).then(r =>
        r.data.content.forEach(item => {
          this.item = item;
        })
      );
    }*/
  }
};
</script>

