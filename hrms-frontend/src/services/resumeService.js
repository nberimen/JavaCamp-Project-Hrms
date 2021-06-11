import axios from 'axios'
export default class ResumeService {
    getResume = resumeId => {
        return axios.get("http://localhost:8080/api/resume/getResume?id=" + resumeId);
    }

    addEducation = (education, resumeId) => {
        return axios.post(`http://localhost:8080/api/resume/education?id= ${resumeId}`, education);
    }

    addEducation = (experience, resumeId) => {
        return axios.post(`http://localhost:8080/api/resume/experiences?id= ${resumeId}`, experience);
    }

    addLanguageSkill = (languageSkill, resumeId) => {
        {
            return axios.post(`http://localhost:8080/api/resume/language-skills?id= ${resumeId}`, languageSkill);
        }

    }
    addTechnicalSkill = (technicalSkill, resumeId) => {
        return axios.post(`http://localhost:8080/api/resume/technical-skills?id= ${resumeId}`, technicalSkill);
    }

    addProfileImage = (file, resumeId) => {
        return axios.post(`http://localhost:8080/api/resume/image-upload?id=${resumeId}`, file);
    }

    addSummary = (summary, resumeId) => {
        return axios.post(`http://localhost:8080/api/resume/summary?id=${resumeId}`, summary);
    }

    addSocialAccounts = (githubAccounts,linkedinAccounts, resumeId) => {
        return axios.post(`http://localhost:8080/api/resume/social-accounts?id=${resumeId}`,githubAccounts,linkedinAccounts);
    }

}