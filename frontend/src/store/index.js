import { createStore } from "vuex";
import SubjectService from "@/services/SubjectService";

export default createStore({
  state: {
    subjects: [],
    subject: {},
    users: [],
    user: {},
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
    },
    SET_USER(state, user) {
      state.user = user;
    },
    SET_USERS(state, users) {
      state.users = users;
    },
  },
  actions: {
    fetchSubject({ commit, state }, id) {
      const existingSubject = state.subjects.find(
        (subject) => subject.id === id
      );
      if (existingSubject) {
        commit("SET_SUBJECT", existingSubject);
      } else {
        return SubjectService.getSubject(id)
          .then((response) => {
            commit("SET_SUBJECT", response.data);
          })
          .catch((error) => {
            throw error;
          });
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
  },
  modules: {},
});
