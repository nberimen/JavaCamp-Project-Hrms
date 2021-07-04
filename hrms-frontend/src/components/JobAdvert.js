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
                .min(3, 'Çok Kısa!')
                .max(250, 'Çok Uzun!')
                .required("Açıklama alanı boş bırakılamaz."),
            openPositionNumber: Yup.string()
                .required("Açık pozisyon alanı boş bırakılamaz."),
            city: Yup.string()
                .required('Şehir boş bırakılamaz'),
            jobPosition: Yup.string()
                .required('İş Pozisyonu boş bırakılamaz'),
            jobType: Yup.string()
                .required('İstihdam Türü boş bırakılamaz'),
            typeOfWork: Yup.string()
            .required('Çalışma Türü boş bırakılamaz')  
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
                    <h1 className="my-4 font-weight-bold-display-4" >İlan Ekle</h1>
                    {/* console.log(formik.values) */}
                    <Form onSubmit={formik.handleSubmit}>

                        <SelectInput
                            label="İş Pozisyonu"
                            name="jobPosition"
                            value={formik.values.jobPosition}
                            options={jobPositions.map(j => ({ value: j.id, label: j.positionName }))}
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.jobPosition && formik.errors.jobPosition}
                        />

                        <SelectInput
                            label="Şehir"
                            name="city"
                            value={formik.values.city}
                            options={cities.map(c => ({ value: c.id, label: c.cityName }))}
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.city && formik.errors.city}
                        />

                        <SelectInput
                            label="İstihdam Türü"
                            name="jobType"
                            value={formik.values.jobType}
                            options={jobTypes.map(j => ({ value: j.id, label: j.jobType }))}
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.jobType && formik.errors.jobType}
                        />

                        <SelectInput
                            label="Çalışma Türü"
                            name="typeOfWork"
                            value={formik.values.typeOfWork}
                            options={typesOfWork.map(t => ({ value: t.id, label: t.workType }))}
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.typeOfWork && formik.errors.typeOfWork}
                        />

                        <TextInput
                            label="Açıklama"
                            name="description"
                            type="text"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />

                        <TextInput
                            label="Maaş-Min"
                            name="minSalary"
                            type="number"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />

                        <TextInput
                            label="Maaş-Max"
                            name="maxSalary"
                            type="number"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />

                        <TextInput
                            label="Açık Pozisyon Sayısı"
                            name="openPositionNumber"
                            type="number"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            value={formik.values.openPositionNumber}
                        />

                        <TextInput
                            label="Bitiş Tarihi"
                            name="deadline"
                            type="date"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />




                        <button className="btn btn-dark mt-3" type="submit">Yayınla</button>

                    </Form>
                </div>
            )

            }
        </Formik>
    )
}

export default JobAdvert
