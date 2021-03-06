import React, { useEffect, useState } from 'react';
import { Formik, Form, useFormik } from 'formik'
import * as Yup from 'yup'

import CityService from '../services/cityService'
import JobPositionService from '../services/jobPositionService';
import JobTypeService from '../services/jobTypeService';
import TypeOfWorkService from '../services/typeOfWorkService'

import SelectInput from '../utilities/customFormControl/SelectInput';
import TextInput from '../utilities/customFormControl/TextInput'

const JobAdvert = () => {
    const [cities, setCities] = useState([]);
    const [jobPositions, setJobPositions] = useState([]);
    const [jobTypes, setJobTypes] = useState([])
    const [typesOfWork, setTypesOfWork] = useState([])

    useEffect(() => {
        loadCities();
        loadJobPositions();
        loadJobTypes();
        loadTypesOfWork();
    }, []);

    const loadCities = async () => {
        let cityService = new CityService()
        try {
            const result = await cityService.getAllCities();
            setCities(result.data.data)
        } catch (error) {

        }
    }
    console.log(cities)

    const loadJobPositions = async () => {
        let jobPositionService = new JobPositionService();
        try {
            const result = await jobPositionService.getAllJobPositions();
            setJobPositions(result.data.data)
        } catch (error) {

        }
    }
    const loadJobTypes = async () => {
        let jobTypeService = new JobTypeService();
        try {
            const result = await jobTypeService.getAllJobTypes();
            setJobTypes(result.data.data)
        } catch (error) {

        }
    }

    const loadTypesOfWork = async () => {
        let typeOfWorkService = new TypeOfWorkService();
        try {
            const result = await typeOfWorkService.getAllTypesOfWork();
            setTypesOfWork(result.data.data)
        } catch (error) {

        }
    }


    const initialValues = {
        description: "",
        minSalary: "",
        maxSalary: "",
        openPositionNumber: "",
        deadline: "",
        jobType: "",
        typeOfWork: "",
        jobPosition: "",
        city: ""
    }
    const validationSchema =
        Yup.object({
            description: Yup.string()
                .min(3, '??ok K??sa!')
                .max(250, '??ok Uzun!')
                .required("A????klama alan?? bo?? b??rak??lamaz."),
            openPositionNumber: Yup.string()
                .required("A????k pozisyon alan?? bo?? b??rak??lamaz."),
            city: Yup.string()
                .required('??ehir bo?? b??rak??lamaz'),
            jobPosition: Yup.string()
                .required('???? Pozisyonu bo?? b??rak??lamaz'),
            jobType: Yup.string()
                .required('??stihdam T??r?? bo?? b??rak??lamaz'),
            typeOfWork: Yup.string()
            .required('??al????ma T??r?? bo?? b??rak??lamaz')  
        })


    return (
        <Formik
            initialValues={initialValues}
            validationSchema={validationSchema}
            onSubmit={values => {
                console.log(values)
            }}
        >
            {formik => (
                <div>
                    <h1 className="my-4 font-weight-bold-display-4" >??lan Ekle</h1>
                    {/* console.log(formik.values) */}
                    <Form onSubmit={formik.handleSubmit}>

                        <SelectInput
                            label="???? Pozisyonu"
                            name="jobPosition"
                            value={formik.values.jobPosition}
                            options={jobPositions.map(j => ({ value: j.id, label: j.positionName }))}
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.jobPosition && formik.errors.jobPosition}
                        />

                        <SelectInput
                            label="??ehir"
                            name="city"
                            value={formik.values.city}
                            options={cities.map(c => ({ value: c.id, label: c.cityName }))}
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.city && formik.errors.city}
                        />

                        <SelectInput
                            label="??stihdam T??r??"
                            name="jobType"
                            value={formik.values.jobType}
                            options={jobTypes.map(j => ({ value: j.id, label: j.jobType }))}
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.jobType && formik.errors.jobType}
                        />

                        <SelectInput
                            label="??al????ma T??r??"
                            name="typeOfWork"
                            value={formik.values.typeOfWork}
                            options={typesOfWork.map(t => ({ value: t.id, label: t.workType }))}
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.typeOfWork && formik.errors.typeOfWork}
                        />

                        <TextInput
                            label="A????klama"
                            name="description"
                            type="text"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />

                        <TextInput
                            label="Maa??-Min"
                            name="minSalary"
                            type="number"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />

                        <TextInput
                            label="Maa??-Max"
                            name="maxSalary"
                            type="number"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />

                        <TextInput
                            label="A????k Pozisyon Say??s??"
                            name="openPositionNumber"
                            type="number"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            value={formik.values.openPositionNumber}
                        />

                        <TextInput
                            label="Biti?? Tarihi"
                            name="deadline"
                            type="date"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />




                        <button className="btn btn-dark mt-3" type="submit">Yay??nla</button>

                    </Form>
                </div>
            )

            }
        </Formik>
    )
}

export default JobAdvert
