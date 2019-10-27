import DatabaseList from "./components/DatabaseList.vue";
import DatabaseEdit from "./components/DatabaseEdit.vue";

const routes = [
  { path: "/", redirect: "/databases" },
  {
    path: "/databases",
    component: DatabaseList
  },
  { path: "/databases/:id", component: DatabaseEdit, props: true }
];

export default {
  routes
};
