import { createStore } from "vuex";
import SubjectService from "@/services/SubjectService";
import user from "@/services/user.service";
import { auth } from "./auth.module";

export default createStore({
  state: {
    mainUser: {},
    subjects: [],
    subject: {},
    users: [],
    user: {
      username: {
        userLevel: {
          id: 3,
        },
      },
    },
  },
  getters: {},
  mutations: {
    ADD_SUBJECT(state, subject) {
      state.subjects.push(subject);
    },
    SET_SUBJECT(state, subject) {
      state.subject = subject;
    },
    SET_SUBJECTS(state, subjects) {
      state.subjects = subjects;
      console.log(subjects);
    },
    SET_USER(state, user) {
      state.user = user;
      console.log(user);
    },
    SET_USERS(state, users) {
      state.users = users;
    },
    SET_LEVEL(state, level) {
      state.level = level;
    },
  },
  actions: {
    commitLevel({ commit, state }, level) {
      commit.SET_LEVEL(state, level);
    },
    fetchSubject({ commit, state }, id) {
      console.log(id);
      console.log(state.subjects.student);
      const existingSubject = state.subjects.student.id.find(
        (subject) => subject === id
      );
      console.log(existingSubject);
      console.log("her2");
      if (existingSubject) {
        console.log("her3");
        commit("SET_SUBJECT", existingSubject);
      }
    },
    fetchSubjects({ commit }) {
      return SubjectService.getSubjects()
        .then((response) => {
          commit("SET_SUBJECTS", response.data);
        })
        .catch((error) => {
          throw error;
        });
    },
    fetchUsers({ commit }) {
      return SubjectService.getUsers()
        .then((response) => {
          commit("SET_USERS", response.data);
        })
        .catch((error) => {
          throw error;
        });
    },
    fetchUser({ commit }) {
      return user.getUser().then((response) => {
        commit("SET_USER", response.data);
      });
    },
  },
  modules: {
    auth,
  },
});
