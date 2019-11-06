import DatabaseList from "./components/DatabaseList.vue";
import DatabaseEdit from "./components/DatabaseEdit.vue";

const routes = [
  { title: "Database watcher - Home", path: "/", redirect: "/databases" },
  {
    name: "databases",
    path: "/databases",
    component: DatabaseList
  },
  {
    name: "database-new",
    path: "/databases/new",
    component: DatabaseEdit
  },
  {
    name: "database-edit",
    path: "/databases/:id",
    component: DatabaseEdit,
    props: true
  }
];

export default {
  routes
};
