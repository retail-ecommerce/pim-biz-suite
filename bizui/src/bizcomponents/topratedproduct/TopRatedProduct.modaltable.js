
import React, { PureComponent } from 'react'
import moment from 'moment'
import { Table, Alert, Badge } from 'antd'
import styles from './TopRatedProduct.table.less'
import ImagePreview from '../../components/ImagePreview'
import TopRatedProductBase from './TopRatedProduct.base'
import appLocaleName from '../../common/Locale.tool'

class TopRatedProductModalTable extends PureComponent {
  render() {
    // const { data,count,current, owner } = this.props
    const { data } = this.props
	const {displayColumns} = TopRatedProductBase
	const userContext = null
	if(!data){
		return null
	}
	if(!data.length){
		return null
	}
	
    return (
      <div className={styles.standardTable}>
        <div className={styles.tableAlert}>
          <Alert
            message={(
              <p>
                {appLocaleName(userContext,"Totally")} <a style={{ fontWeight: 600 }}>{data.length}</a> {appLocaleName(userContext,"Items")} 
              </p>
            )}
            type="warning"
            showIcon
          />
        </div>
        <Table
          rowKey={record => record.id}
          dataSource={data}
          columns={displayColumns}
          size="small"
          scroll={{ x: 2670 }}
        />
      </div>
    )
  }
}

export default TopRatedProductModalTable

