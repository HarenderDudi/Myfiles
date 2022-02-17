import axios from "axios";
import { GET_ERRORS, GET_PROJECT, GET_PROJECTS } from "./types";

export const createProject = (project, history, isUpdate) => async dispatch => {
    try {
        if(isUpdate) {
            await axios.put("http://localhost:5002/project", project);
        } else {
            await axios.post("http://localhost:5002/project", project);
        }
       
        history.push("/dashboard");
    } catch (err) {
        dispatch({
            type: GET_ERRORS,
            payload: err.response.data
        });
    }
};

export const getProjects = () => async dispatch => {
    const resp = await axios.get("http://localhost:5002/project/all");
    dispatch({
        type: GET_PROJECTS,
        payload: resp.data
    });
};  


export const getProject = projectId => async dispatch => {
    
    const resp = await axios.get(`http://localhost:5002/project/${projectId}`);
    dispatch({
        type: GET_PROJECT,
        payload: resp.data
    });

};