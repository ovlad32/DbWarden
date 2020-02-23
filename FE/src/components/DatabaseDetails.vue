<template>
  <article>
    <div class="media-content">
      <div class="container">
        <p>
          <span>Service user:</span>
          <span>{{serviceUser}}</span>
          <a class="button is-small is-white">
            <fa icon="edit" size="xs" />
          </a>
        </p>
        <p>
          <span>updated:</span>
          <span>{{updated}}</span>
          <a class="button is-small is-white">
            <fa icon="redo-alt" size="xs" />
          </a>
        </p>
        <p>
          <span>Online status:</span>
          <span>{{status}}</span>
          <a class="button is-small is-white">
            <fa icon="sync-alt" size="xs" />
          </a>
        </p>
        <button class="button">update statistics</button>
        <button class="button">edit</button>
        <button class="button">remove</button>
      </div>
    </div>
  </article>
</template>

<script>
export default {
  props: {
    serviceUser: {
      type: String,
      required: true
    },
    status: {
      type: String,
      required: true
    },
    updated: {
      type: String
    }
  },
  data() {
    return {};
  }
};
</script>