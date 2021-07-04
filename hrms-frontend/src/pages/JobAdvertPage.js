import React from 'react'
import AddvertJob from '../components/JobAdvert'
import addvertJobPng from '../images/jobAddvert.png'

const JobAdvertPage = () => {
   
    return (
        <div className="container mt-3">
            <div className="row">
                <div className="col-md-5">
                    <AddvertJob/>
                </div>
                <div className="col-md-7 my-auto">
                    <img className="img-fluid w-100 ps-5" src={addvertJobPng} alt="singup png"/>
                </div>
            </div>
        </div>
    )
}
export default JobAdvertPage