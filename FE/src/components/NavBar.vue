<template>
  <nav class="navbar navbar-expand navbar-light bg-light">
    <!--
      <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarTogglerDemo01"
      aria-controls="navbarTogglerDemo01"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    -->
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav mr-auto mt-2">
        <router-link tag="li" class="navbar-item" to="/databases">
          <a href="#" class="nav-link">DataSources</a>
        </router-link>
        <router-link to="/statistics" class="navbar-item">
          <a href="#" class="nav-link">Statistics</a>
        </router-link>
        <router-link to="/processing" class="navbar-item">
          <a href="#" class="nav-link">Processing</a>
        </router-link>
      </ul>
      <form class="form-inline my-2">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" />
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
</template>
