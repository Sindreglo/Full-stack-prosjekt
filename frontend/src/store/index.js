import { createStore } from "vuex";
import SubjectService from "@/services/SubjectService";
import user from "@/services/user.service";

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
    fetchUser({ commit }) {
      return user.getUser().then((response) => {
        commit("SET_USER", response.data);
      });
    },
  },
  modules: {},
});
