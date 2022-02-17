import React, { Component } from 'react'
import CreateProjectButton from './projects/CreateProjectButton.js'
import ProjectItems from './projects/ProjectItems.js'
import {connect} from "react-redux"
import PropTypes from "prop-types"
import { getProjects } from '../actions/projectActions.js'


class Dashboard extends Component {

    componentDidMount(){
        this.props.getProjects();
    }

    render() {

       const {projects} = this.props.project;
    //    const project = {
    //        "projectName" : "Name",
    //        "projectIdentifier": "id",
    //        "projectDescription": "description"
    //    }

        return (
            <div className="projects">
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <h1 className="display-4 text-center">Projects</h1>
                            <br />
                                <CreateProjectButton></CreateProjectButton>
                            <br />
                            <hr />

                            {
                                projects.map(project => <ProjectItems key={project._id} projects={project}></ProjectItems>)                                
                            }
                            
                        </div>
                    </div>
                </div>
             </div>

        )
    }
}

Dashboard.propTypes = {
    project: PropTypes.object.isRequired,
    getProjects: PropTypes.func.isRequired
}

const mapStateToProps = state => ({
    project: state.project
})

export default connect(mapStateToProps, {getProjects})(Dashboard)
