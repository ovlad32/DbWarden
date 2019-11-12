<template>
  <div class="dbedit">
    <p class="db-title">New Database Server</p>

    <b-form class="databaseConfig" style="background:lightyellow">
      <b-form-group label="Type" label-for="typeFormId">
        <b-form-select
          id="typeFormId"
          v-model="item.type"
          :options="types"
          value-field="type"
          text-field="name"
        ></b-form-select>
      </b-form-group>
    </b-form>
  </div>
  <!--  

       class="form-group row">
        <label for="typeFormId" class="col-sm-2 col-form-label"></label>
        <div class="mr-auto">
          <select id="typeFormId" class="form-control" v-model="">
            <option v-for="d in types" :key="d.type" :value="d.type" :label="d.name" />
          </select>
        </div>
      </div>
      <div class="form-group row">
        <label for="urlFormId" class="label">URI</label>
        <div class="mr-auto">
          <input v-model="item.url" id="urlFormId" class="input" type="text" placeholder size="50" />
        </div>
      </div>
    </form>
  </div>
  <section class="section columns">
    <form class="databaseConfig column is-5 is-offset-1" style="background:lightyellow">
      <div class="container">
        <div class="field is-horizontal">
          <div class="field-label is-normal">
            
          </div>
          <div class="field-body">
            <div class="field">
              <p class="control is-expanded has-icons-left">
                <span class="select">
               
                </span>
                <span class="icon is-small is-left">
                  <fa icon="folder" />
                </span>
              </p>
            </div>
          </div>
        </div>
        <div class="field is-horizontal">
          <div class="field-label is-normal">
            <label for="urlFormId" class="label">URI</label>
          </div>
          <div class="field-body">
            <p class="control is-expanded has-icons-left">
              <input
                v-model="item.url"
                id="urlFormId"
                class="input"
                type="text"
                placeholder
                size="50"
              />
              <span class="icon is-small is-left">
                <fa icon="server" />
              </span>
            </p>
          </div>
        </div>
        <div class="field is-horizontal">
          <div class="field-label is-normal">
            <label for="aliasFormId" class="label">Alias</label>
          </div>
          <div class="field-body">
            <p class="control is-expanded has-icons-left">
              <input
                v-model="item.alias"
                class="input"
                id="aliasFormId"
                type="text"
                placeholder
                size="50"
              />
              <span class="icon is-small is-left">
                <fa icon="database" />
              </span>
            </p>
          </div>
        </div>
        <div class="field is-horizontal">
          <div class="field-label is-normal">
            <label for="loginFormId" class="label">Login</label>
          </div>
          <div class="field-body">
            <p class="control is-expanded has-icons-left">
              <input
                v-model="item.login"
                class="input"
                id="loginFormId"
                type="text"
                placeholder
                size="50"
              />
              <span class="icon is-small is-left">
                <fa icon="database" />
              </span>
            </p>
          </div>
        </div>
        <div class="field is-horizontal">
          <div class="field-label is-normal">
            <label for="passwordFormId" class="label">Password</label>
          </div>
          <div class="field-body">
            <p class="control is-expanded has-icons-left">
              <input
                class="input"
                v-model="item.password"
                id="passwordFormId"
                type="password"
                placeholder
                size="50"
                autocomplete="new-password"
              />
              <span class="icon is-small is-left">
                <fa icon="database" />
              </span>
            </p>
          </div>
        </div>
        <div class="field is-horizontal db-button-group">
          <div class="field-label"></div>
          <div class="field-body">
            <div class="field is-grouped is-grouped-right">
              <span class="control">
                <button
                  class="button is-primary"
                  type="submit"
                  @click.prevent="save"
                >Create DataSource</button>
              </span>
              <span class="control">
                <a class="button is-light">Close</a>
              </span>
            </div>
          </div>
        </div>
      </div>
    </form>
  </section>
  -->
</template>

<style>
.db-button-group {
  padding-top: 0.5em;
}
.db-title {
  font-size: 2em;
  padding-bottom: 0.5em;
}
.dialog {
  display: flex;
  background: blueviolet;
}
</style>


<script>
//import { mapState, mapActions } from "vuex";
import dcAPI from "../api/databases";
export default {
  props: {
    id: { type: [Number, String] }
  },
  data() {
    return {
      types: [],
      item: {}
    };
  },
  methods: {
    save() {
      dcAPI.save(this.item);
    },
    checkParams() {
      dcAPI.checkParams(this.item);
    }
  },
  mounted() {
    dcAPI.getTypes().then(r => {
      this.types = r.data;
      /*.map(e => {
        return;
        {
          text: e.name;
          value: e.type;
        }
      });*/
    });
    if (this.id) {
      dcAPI.getAll({ id: this.id }).then(r =>
        r.data.content.forEach(item => {
          this.item = item;
        })
      );
    }
  }
};
</script>

