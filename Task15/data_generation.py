#!/usr/bin/python3
# coding: utf-8

import pandas as pd
import numpy as np

# anonymization function for zipcode
def process_zip(df):
    newdf = df
    for i,row in newdf.iterrows():
        tmp = str(row['zip'])
        new_zip = tmp[:3]
        for j in range(len(tmp)-3):
            new_zip = new_zip + '*'
        newdf.at[i,'zip'] = new_zip
    return newdf

# anonymization function fot date of birth
def process_dob(df):
    newdf = df
    for i,row in newdf.iterrows():
        tmp = str(row['dob']).split('-')
        newdf.at[i,'dob'] = tmp[0]
    return newdf

# read csv files
alldf= pd.read_csv('customer-databases/all.csv', sep=';')
grocerydf = pd.read_csv('customer-databases/grocery_store.csv', sep=';')
insurancedf = pd.read_csv('customer-databases/insurance_company.csv', sep=';')
insurancehealthdf = pd.read_csv('customer-databases/insurance_health.csv', sep=';')
diseasedf = pd.read_csv('customer-databases/disease_id.csv', sep=';')
prescriptiondf = pd.read_csv('customer-databases/prescriptions.csv', sep=';')

# merge csv files
newdf = alldf.merge(grocerydf, how="left", on="grocery_member_id", suffixes=('', '_y'))
newdf.drop(list(newdf.filter(regex = '_y')), axis = 1, inplace = True)

newdf = newdf.merge(insurancedf, how="left", on="insurance_member_id", suffixes=('', '_y'))
newdf.drop(list(newdf.filter(regex = '_y')), axis = 1, inplace = True)

newdf = newdf.merge(insurancehealthdf, how="left", on="insurance_id", suffixes=('', '_y'))
newdf.drop(list(newdf.filter(regex = '_y')), axis = 1, inplace = True)

newdf = newdf.merge(diseasedf, how="left", on="disease_id", suffixes=('', '_y'))
newdf.drop(list(newdf.filter(regex = '_y')), axis = 1, inplace = True)

newdf = newdf.merge(prescriptiondf, how="left", on="perscription_id", suffixes=('', '_y'))
newdf.drop(list(newdf.filter(regex = '_y')), axis = 1, inplace = True)

# suppress some columns
newdf2 = newdf.drop(['firstname','lastname','address','credit_card','ssn','insurance_member_id','insurance_health_id','perscription_id', 'insurance_id'], axis=1, errors='ignore')

# anonymization
newdf2['zip'] = newdf2['zip'].astype(str)
newdf3 = process_zip(newdf2)
newdf4 = process_dob(newdf3)

newdf4.to_csv('deidentified.csv', sep=';', index=False)